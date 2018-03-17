package com.igorini.togepibot.commands.general

import com.igorini.kotlintwitchbot.ext.randomViewerExcept
import com.igorini.kotlintwitchbot.ext.viewerOnlineExcept
import com.igorini.togepibot.TogepiBot.Companion.botUsers
import com.igorini.togepibot.TogepiBot.Companion.negativeEmotes
import com.igorini.togepibot.TogepiBot.Companion.positiveEmotes
import com.igorini.togepibot.model.*
import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.message.commands.Command
import me.philippheuer.twitch4j.message.commands.CommandPermission
import org.jetbrains.exposed.sql.transactions.transaction
import java.math.BigDecimal

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
        val opponentUsername : String?

        if (words.size == 1) {
            opponentUsername = randomViewerExcept(messageEvent, botUsers.plus(username))
            if (opponentUsername == null) {
                // TODO: Modify kotlin-twitch-bot and throw an exception instead
                sendMessageToChannel(channelName, "Достойных соперников не обнаружено. Kappa")
                return
            }
        } else {
            opponentUsername = words[1].replaceFirst("^@".toRegex(), "").toLowerCase()
            if (opponentUsername == username) {
                sendMessageToChannel(channelName, "Хорошая попытка, $userDisplayName TehePelo")
                return
            }
            if (!viewerOnlineExcept(messageEvent, opponentUsername, botUsers)) {
                sendMessageToChannel(channelName,"Пользователь $opponentUsername в чате не найден, или он бот. Kappa")
                return
            }
        }

        val opponentDisplayName = findDisplayName(opponentUsername)

        var winner: User? = null
        var user: User? = null
        var opponent: User?
        var channel: Channel?

        // TODO: Split into multiple transactions?
        transaction {
            channel = findChannelOrInsert(channelName)
            user = findUserOrInsert(username, userDisplayName)
            opponent = findUserOrInsert(opponentUsername, opponentDisplayName)
            winner = listOf(user, opponent).shuffled().first()

            upsertDuelist(channel!!, user!!, winner!!)
            upsertDuelist(channel!!, opponent!!, winner!!)
        }

        val emote = if (winner == user) positiveEmotes.shuffled().first() else negativeEmotes.shuffled().first()

        val replies = listOf(
                "За право стать величайшим мастером боевых искусств всех времён, $userDisplayName вызывает на бой $opponentDisplayName! ʕง•ᴥ•ʔง Побеждает ${winner!!.displayName}! $emote",
                "$userDisplayName vs $opponentDisplayName. FIGHT! ʕง•ᴥ•ʔง ${winner!!.displayName} wins! Flawless victory! $emote",
                "$opponentDisplayName принимает вызов $userDisplayName! ʕง•ᴥ•ʔง В этот раз победу одерживает ${winner!!.displayName}! $emote",
                "В решающей битве за Лордерон PurpleStar сошлись прославленные герои - $userDisplayName и $opponentDisplayName! Победа за ${winner!!.displayName}! $emote")

        sendMessageToChannel(channelName, replies.shuffled().first())
    }

    // TODO: Call a function that does this in the background
    private fun findChannelOrInsert(channelName: String): Channel {
        val result = Channel.find { Channels.name eq channelName }
        return if (result.empty()) Channel.new { name = channelName } else result.first()
    }

    private fun findUserOrInsert(username: String, userDisplayName: String): User {
        val result = User.find { Users.name eq username }
        return if (result.empty()) {
            User.new {
                name = username
                displayName = userDisplayName
            }
        } else result.first()
    }

    private fun upsertDuelist(channel: Channel, user: User, winner: User) = if (channel.duelists.any { it.user == user }) {
        updateDuelist(channel, user, winner == user)
    } else {
        insertDuelist(channel, user, winner == user)
    }

    private fun insertDuelist(duelistChannel: Channel, duelistUser: User, won: Boolean) {
        Duelist.new {
            channel = duelistChannel
            user = duelistUser
            duels = 1
            wins = if (won) 1 else 0
            losses = if (won) 0 else 1
            winrate = if (won) BigDecimal("100.0000") else BigDecimal("0.0000")
        }
    }

    // TODO: Refactor with inner functions
    private fun updateDuelist(duelistChannel: Channel, duelistUser: User, won: Boolean) {
        // TODO: Check if the second query to Duelists can be avoided
        with (duelistChannel.duelists.find { it.user == duelistUser }!!) {
            duels++
            if (won) wins++ else losses++
            winrate = recalculateWinrate()
        }
    }

    // TODO: Move to an extension function to a class Command in kotlin-twitch-bot
    private fun findDisplayName(username: String): String {
        val user = twitchClient.userEndpoint.getUserByUserName(username)
        return if (user.isPresent) user.get().displayName else username
    }
}