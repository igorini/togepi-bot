package com.igorini.togepibot.commands.general

import com.igorini.kotlintwitchbot.ext.randomViewerExcept
import com.igorini.kotlintwitchbot.ext.viewerOnlineExcept
import com.igorini.togepibot.TogepiBot.Companion.botUsers
import com.igorini.togepibot.TogepiBot.Companion.negativeEmotes
import com.igorini.togepibot.TogepiBot.Companion.positiveEmotes
import com.igorini.togepibot.model.Channels
import com.igorini.togepibot.model.Duelists
import com.igorini.togepibot.model.Users
import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.message.commands.Command
import me.philippheuer.twitch4j.message.commands.CommandPermission
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.math.BigDecimal
import java.math.RoundingMode

/** Represents a command that performs a duel against someone in chat */
class Duel : Command() {
    init {
        command = "дуэль"
        commandAliases = arrayOf("duel", "fight", "поединок", "махач", "бой", "битва", "борьба", "вызов", "вызываю", "драка")
        category = "general"
        description = "Вызовите оппонента на дуэль"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!дуэль @username"
    }

    override fun executeCommand(messageEvent: ChannelMessageEvent?) {
        super.executeCommand(messageEvent)

        val channelName = messageEvent!!.channel.name!!
        val words = messageEvent.message.split("\\s".toRegex())

        val username = messageEvent.user.name.toLowerCase()
        val userDisplayName = messageEvent.user.displayName!!
        val opponent : String?

        if (words.size == 1) {
            opponent = randomViewerExcept(messageEvent, botUsers.plus(username))
            if (opponent == null) {
                // TODO: Modify kotlin-twitch-bot and throw an exception instead
                sendMessageToChannel(channelName, "Достойных соперников не обнаружено. Kappa")
                return
            }
        } else {
            opponent = words[1].replaceFirst("^@".toRegex(), "").toLowerCase()
            if (opponent == username) {
                sendMessageToChannel(channelName, "Хорошая попытка, $userDisplayName TehePelo")
                return
            }
            if (!viewerOnlineExcept(messageEvent, opponent, botUsers)) {
                sendMessageToChannel(channelName,"Пользователь $opponent в чате не найден, или он бот. Kappa")
                return
            }
        }

        val opponentDisplayName = findDisplayName(opponent)

        val winner = listOf(userDisplayName, opponentDisplayName).shuffled().first()

        transaction {
            Channels.insertIgnore { it[name] = channelName }

            Users.insertIgnore {
                it[name] = username
                it[displayName] = userDisplayName
            }

            Users.insertIgnore {
                it[name] = opponent
                it[displayName] = opponentDisplayName
            }

            upsertDuelist(channelName, username, winner.toLowerCase())
            upsertDuelist(channelName, opponent, winner.toLowerCase())
        }

        val emote = if (winner == userDisplayName) positiveEmotes.shuffled().first() else negativeEmotes.shuffled().first()

        val replies = listOf(
                "За право стать величайшим мастером боевых искусств всех времён, $userDisplayName вызывает на бой $opponentDisplayName! ʕง•ᴥ•ʔง Побеждает $winner! $emote",
                "$userDisplayName vs $opponentDisplayName. FIGHT! ʕง•ᴥ•ʔง $winner wins! Flawless victory! $emote",
                "$opponentDisplayName принимает вызов $userDisplayName! ʕง•ᴥ•ʔง В этот раз победу одерживает $winner! $emote",
                "В решающей битве за Лордерон PurpleStar сошлись прославленные герои - $userDisplayName и $opponentDisplayName! Победа за $winner! $emote")

        sendMessageToChannel(channelName, replies.shuffled().first())
    }

    private fun upsertDuelist(channelName: String, username: String, winner: String) = if (duelistPersisted(channelName, username)) {
        updateDuelist(channelName, username, winner == username)
    } else {
        insertDuelist(channelName, username, winner == username)
    }

    private fun insertDuelist(dChannelName: String, dUserName: String, won: Boolean) {
        Duelists.insert {
            it[channelName] = dChannelName
            it[userName] = dUserName
            it[duels] = 1
            it[wins] = if (won) 1 else 0
            it[losses] = if (won) 0 else 1
            it[winrate] = calculateWinrate(if (won) 1 else 0, 1)
        }
    }

    private fun updateDuelist(dChannelName: String, dUserName: String, won: Boolean) {
        val cDuels: Int
        val cWins: Int

        Duelists.select {
            (Duelists.channelName eq dChannelName) and (Duelists.userName eq dUserName)
        }.first()

        Duelists.update ({ (Duelists.channelName eq dChannelName) and (Duelists.userName eq dUserName) }) {
            with(SqlExpressionBuilder) {
                val duels = (Duelists.duels + 1)
                it.update(Duelists.duels, Duelists.duels + 1)
                if (won) {
                    it.update(Duelists.wins, Duelists.wins + 1)
                    it.update(Duelists.winrate, )
                } else {
                    it.update(Duelists.losses, Duelists.losses + 1)
                }
            }
        }
    }

    private fun calculateWinrate(wins: Int, duels: Int) = BigDecimal(wins).divide(BigDecimal(duels), 4, RoundingMode.HALF_UP)

    private fun duelistPersisted(channelName: String, username: String) = Duelists.select {
        (Duelists.channelName eq channelName) and (Duelists.userName eq username)
    }.any()

    // TODO: Move to an extension function to a class Command in kotlin-twitch-bot
    private fun findDisplayName(username: String): String {
        val user = twitchClient.userEndpoint.getUserByUserName(username)
        return if (user.isPresent) user.get().displayName else username
    }
}