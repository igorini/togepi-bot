package com.igorini.togepibot.commands.general.duel

import com.igorini.kotlintwitchbot.ext.randomViewerExcept
import com.igorini.kotlintwitchbot.ext.viewerOnlineExcept
import com.igorini.togepibot.TogepiBot.Companion.botUsers
import com.igorini.togepibot.TogepiBot.Companion.negativeEmotes
import com.igorini.togepibot.TogepiBot.Companion.positiveEmotes
import com.igorini.togepibot.TogepiBot.Companion.togepiBotAdmin
import com.igorini.togepibot.commands.general.duel.crit.*
import com.igorini.togepibot.ext.random
import com.igorini.togepibot.model.*
import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.message.commands.Command
import me.philippheuer.twitch4j.message.commands.CommandPermission
import mu.KotlinLogging
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import org.joda.time.Period
import kotlin.math.roundToInt

/** Represents a command that performs a duel against someone in chat */
class Duel : Command() {

    val logger = KotlinLogging.logger {}

    companion object {
        @JvmField val initialHP = 100
        @JvmField val minDamage = 5
        @JvmField val baseDamage = 0.1
        @JvmField val cooldownForRandom = 30
        @JvmField val cooldownForSpecific = 60
        // TODO: For variety add with what
        @JvmField val winMessages = listOf("побеждает", "уничтожает", "бьёт", "побивает", "кусает", "пинает", "делает кусь", "отвлекает", "делает вжик-вжик", "атакует", "нападает на", "пронзает", "ранит", "даёт пощёчину", "даёт щелбан", "даёт подзатыльник", "даёт леща", "шлёпает", "унижает", "ставит на колени", "царапает")
        @JvmField val loseMessages = listOf("проигрывает")
        @JvmField val howMessage = listOf("безжалостно", "яростно", "без грамма совести", "с радостью", "со злорадством", "элегантно", "стильно", "резко", "сильно", "мощно", "быстро", "увесисто", "жестоко", "коварно", "мило", "с любовью", "отчаянно", "шутя", "как боженька", "нежно", "ласково", "аккуратно", "точно", "с гордостью", "с честью", "отважно", "нелепо", "неуклюже", "без сожаления")
        @JvmField val damageMessages = listOf("пожирает", "крадёт", "лайфстилит", "отнимает", "лечит", "растёт на", "восстанавливает", "похищает", "забирает", "высасывает", "поглощает")
        @JvmField val hpAliases = listOf("хп")
        @JvmField val deathEmotes = listOf("riPepperonis")
        @JvmField val deathMessages = listOf("умирает")
        @JvmField val ressurectEmotes = listOf("BlessRNG")
        @JvmField val ressurectMessages = listOf("возвращается к жизни")
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
        val opponentUsername: String?
        var randomViewer = false
        if (words.size == 1) {
            try {
                // TODO: In kotlin-twitch-bot cache viewer list
                opponentUsername = randomViewerExcept(messageEvent, botUsers.plus(username))
            } catch (e: Exception) {
                logger.error(e) {}
                return
            }
            if (opponentUsername == null) {
                // TODO: Modify kotlin-twitch-bot and throw an exception instead
                sendMessageToChannel(channelName, "Достойных соперников не обнаружено. Kappa")
                return
            }
            randomViewer = true
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
            logger.error(e) {}
            return
        }

        // TODO: Split into multiple transactions?
        try {
            transaction {
                val channel = Channels.findOrInsert(channelName)
                var user = Duelists.findOrInsert(Users.findOrInsert(username, userDisplayName), channel)

                if (user.hp <= 0) throw CommandException("Извините, @${user.user.displayName}, но Вы мертвы (${user.hp} хп). BibleThump Вас могут воскресить другие дуэлянты.")
                if (user.user.name != togepiBotAdmin && user.available?.isAfterNow ?: false) {
                    val stunDuration = Period(DateTime.now(), user.available)
                    throw CommandException("${user.user.displayName}, Вы сможете снова подуэлиться через ${if (stunDuration.minutes > 0) stunDuration.minutes.toString() + " мин " else ""}${stunDuration.seconds} сек")
                }

                var opponent = Duelists.findOrInsert(Users.findOrInsert(opponentUsername, opponentDisplayName), channel)
                val duelists = listOf(user, opponent)
                val winner = duelists.random()
                val loser = (duelists - winner).first()
                val base = (duelists.maxBy { it.hp }!!.hp * baseDamage)
                val crit = if (winner == user) Crit.proc() else null
                val damage = crit?.damage(base) ?: base.roundToInt()

                // TODO: add kills if killed
                var killed = false
                var damageAfterInjury = if (damage >= loser.hp){
                    if (loser.hp > 0) killed = true
                    loser.hp
                } else damage
                if (damageAfterInjury < minDamage) damageAfterInjury = minDamage
                val ressurected = winner.hp <= 0 && winner.hp + damageAfterInjury > 0

                val emote = if (winner == user) positiveEmotes.random() else negativeEmotes.random()

                fun updateDuelist(duelist: Duelist, won: Boolean) {
                    with (duelist) {
                        duels++
                        val initiator = duelist == user
                        if (initiator) {
                            available = DateTime.now().plusSeconds(if (randomViewer) cooldownForRandom else cooldownForSpecific)
                            if (ressurected) ressurects++
                        }
                        if (won) {
                            wins++
                            hp += damageAfterInjury
                            if (damageAfterInjury > maxDamage) maxDamage = damageAfterInjury
                            if (killed) kills++
                            if (hp > maxHp) maxHp = hp
                        } else {
                            losses++
                            hp -= damageAfterInjury
                            if (killed) deaths++
                            crit?.let { available = DateTime.now().plusSeconds(crit.stunSec()) }
                        }
                        winrate = recalculateWinrate()
                    }
                }

                updateDuelist(winner, true)
                updateDuelist(loser, false)

                sendMessageToChannel(channelName, "@${winner.user.displayName} (${winner.hp} хп) ${howMessage.random()} ${winMessages.random()} @${loser.user.displayName} (${loser.hp} хп) и ${damageMessages.random()} $damageAfterInjury ${hpAliases.random()}. $emote ${crit?.message() ?: ""}${if (killed) " @" + loser.user.displayName + " " + deathMessages.random() + " " + deathEmotes.random() else ""}${if (ressurected) " @" + winner.user.displayName + " " + ressurectMessages.random() + " " + ressurectEmotes.random() else ""}")
            }
        } catch (e: CommandException) {
            sendMessageToChannel(channelName, e.message)
            return
        }
    }

    // TODO: Change to local function
    fun updateDuelist(duelist: Duelist, won: Boolean, damage: Int, crit: Crit?, initiator: Boolean, killed: Boolean, randomViewer: Boolean) {
        with (duelist) {
            duels++
            if (initiator) available = DateTime.now().plusSeconds(if (randomViewer) cooldownForRandom else cooldownForSpecific)
            if (won) {
                wins++
                hp += damage
                if (damage > maxDamage) maxDamage = damage
                if (killed) kills++
                if (hp > maxHp) maxHp = hp
            } else {
                losses++
                hp -= damage
                if (killed) deaths++
                crit?.let { available = DateTime.now().plusSeconds(crit.stunSec()) }
            }
            winrate = recalculateWinrate()
        }
    }

    // TODO: Move to an extension function to a class Command in kotlin-twitch-bot
    private fun findDisplayName(username: String): String {
        val user = twitchClient.userEndpoint.getUserByUserName(username)
        return if (user.isPresent) user.get().displayName else username
    }
}