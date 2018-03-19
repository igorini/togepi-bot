package com.igorini.togepibot.commands.general.duel

import com.igorini.kotlintwitchbot.ext.randomViewerExcept
import com.igorini.kotlintwitchbot.ext.viewerOnlineExcept
import com.igorini.togepibot.TogepiBot.Companion.botUsers
import com.igorini.togepibot.TogepiBot.Companion.negativeEmotes
import com.igorini.togepibot.TogepiBot.Companion.positiveEmotes
import com.igorini.togepibot.commands.general.duel.crit.*
import com.igorini.togepibot.ext.random
import com.igorini.togepibot.model.*
import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.message.commands.Command
import me.philippheuer.twitch4j.message.commands.CommandPermission
import mu.KotlinLogging
import org.jetbrains.exposed.sql.transactions.transaction
import kotlin.math.roundToInt

/** Represents a command that performs a duel against someone in chat */
class Duel : Command() {

    val logger = KotlinLogging.logger {}

    companion object {
        @JvmField val initialHP = 100
        @JvmField val minDamage = 5
        @JvmField val ressurectHP = initialHP / 2
        @JvmField val baseDamage = 0.1
        @JvmField val winMessages = listOf("побеждает", "уничтожает", "бьет", "побивает", "кусает", "пинает", "делает кусь", "отвлекает")
        @JvmField val loseMessages = listOf("проигрывает")
        @JvmField val howMessage = listOf("безжалостно", "яростно", "без грамма совести", "с радостью", "со злорадством", "элегантно")
        @JvmField val damageMessages = listOf("пожирает", "отжирается на", "лайфстилит", "отнимает", "лечит", "растет на", "восстанавливает")
        @JvmField val hpAliases = listOf("хп")
        @JvmField val deathMessages = listOf("умирает")
    }

    init {
        command = "дуэль"
        commandAliases = arrayOf("duel", "Duel", "DUEL", "fight", "поединок", "махач", "бой", "битва", "борьба", "вызов", "вызываю", "драка", "Дуэль", "ДУЭЛЬ", "дуель", "Дуель", "ДУЕЛЬ", "le'km")
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
        var opponentUsername : String? = null

        if (words.size == 1) {
            try {
                opponentUsername = randomViewerExcept(messageEvent, botUsers.plus(username))
            } catch (e: Exception) {
                println(e.message)
                println(e.stackTrace)
                return
            }
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

        val opponentDisplayName : String?
        try {
            opponentDisplayName = findDisplayName(opponentUsername)
        } catch (e: Exception) {
            println(e.message)
            println(e.stackTrace)
            return
        }

        // TODO: Split into multiple transactions?
        try {
            transaction {
                val channel = Channels.findOrInsert(channelName)
                var user = Duelists.findOrInsert(Users.findOrInsert(username, userDisplayName), channel)

                if (user.hp <= 0) throw CommandException("Извините, ${user.user.displayName}, но вы мертвы. ( •́ﻩ•̀ )")

                var opponent = Duelists.findOrInsert(Users.findOrInsert(opponentUsername, opponentDisplayName), channel)
                val duelists = listOf(user, opponent)
                val winner = duelists.random()
                val loser = (duelists - winner).first()
                val base = (duelists.maxBy { it.hp }!!.hp * baseDamage)
                val crit = if (winner == user) Crit.proc() else null
                val damage = crit?.damage(base) ?: base.roundToInt()

                // TODO: add kills if killed
                var damageAfterInjury = if (damage > loser.hp) loser.hp else damage
                if (damageAfterInjury < minDamage) damageAfterInjury = minDamage

                val emote = if (winner == user) positiveEmotes.random() else negativeEmotes.random()

                updateDuelist(winner, true, damageAfterInjury)
                updateDuelist(loser, false, damageAfterInjury)

                sendMessageToChannel(channelName, "@${winner.user.displayName} ${howMessage.random()} ${winMessages.random()} @${loser.user.displayName} и ${damageMessages.random()} $damageAfterInjury ${hpAliases.random()}. $emote ${crit?.message() ?: ""}${if (loser.hp < 0) loser.user.displayName + " " + deathMessages.random() else ""}")
                //sendMessageToChannel(channelName, generateReply())
            }
        } catch (e: CommandException) {
            sendMessageToChannel(channelName, e.message)
            return
        }
    }

/*    private fun generateReply(winner: Duelist, loser: Duelist, emote: String, damage: Int): String {

    }*/

    // TODO: Refactor with inner functions
    fun updateDuelist(duelist: Duelist, won: Boolean, damage: Int) {
        // TODO: Check if the second query to Duelists can be avoided
        with (duelist) {
            duels++
            if (won) {
                wins++
                hp += damage
                if (damage > maxDamage) maxDamage = damage
            } else {
                losses++
                hp -= damage
                if (hp <= 0) deaths++
            }
            winrate = recalculateWinrate()
        }
        /*
            var channel by Channel referencedOn Duelists.channel
    var user by User referencedOn Duelists.user
    var duels by Duelists.duels
    var wins by Duelists.wins
    var losses by Duelists.losses
    var winrate by Duelists.winrate
    var hp by Duelists.hp
    var maxDamage by Duelists.maxDamage
    var maxHp by Duelists.maxHp
    var kills by Duelists.kills
    var deaths by Duelists.deaths
    var lastDuel by Duelists.lastDuel
         */
    }

    // TODO: Move to an extension function to a class Command in kotlin-twitch-bot
    private fun findDisplayName(username: String): String {
        val user = twitchClient.userEndpoint.getUserByUserName(username)
        return if (user.isPresent) user.get().displayName else username
    }
}