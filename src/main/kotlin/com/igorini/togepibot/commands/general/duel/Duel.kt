package com.igorini.togepibot.commands.general.duel

import com.igorini.kotlintwitchbot.ext.randomViewerExcept
import com.igorini.kotlintwitchbot.ext.viewerOnlineExcept
import com.igorini.togepibot.TogepiBot.Companion.botUsers
import com.igorini.togepibot.TogepiBot.Companion.negativeEmotes
import com.igorini.togepibot.TogepiBot.Companion.positiveEmotes
import com.igorini.togepibot.TogepiBot.Companion.togepiBotAdmin
import com.igorini.togepibot.commands.general.duel.crit.Crit
import com.igorini.togepibot.ext.quotes
import com.igorini.togepibot.ext.random
import com.igorini.togepibot.model.*
import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.message.commands.Command
import me.philippheuer.twitch4j.message.commands.CommandPermission
import org.jetbrains.exposed.sql.transactions.transaction
import mu.KotlinLogging
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
        @JvmField val cooldownHpFactor = 0.1
        @JvmField val titlelessUsernames = listOf(togepiBotAdmin)
        // TODO: For variety add with what
        @JvmField val simpleAttackMessages = listOf("побеждает", "уничтожает", "бьёт", "побивает", "кусает", "пинает", "делает кусь", "отвлекает", "делает вжик-вжик", "атакует", "нападает на", "пронзает", "ранит", "даёт пощёчину", "даёт щелбан", "даёт подзатыльник", "даёт леща", "шлёпает", "унижает", "ставит на колени", "царапает")
        @JvmField val doesMessages = listOf("атакует", "пронзает", "ранит", "царапает", "штурмует", "режет", "рассекает", "рубит", "сечёт", "протыкает", "выкалывает", "вырубает", "ударяет", "травмирует", "жалит", "повреждает", "дубасит", "жахает")
        @JvmField val shootMessages = listOf("стреляет", "пуляет", "выстреливает", "делает пиу-пиу", "делает точный выстрел")
        @JvmField val weapons = listOf("автомата", "пистолета", "револьвера", "лука", "арбалета", "ружья", "винтовки", "рогатки", "пушки", "АК-47", "узи", "эмки", "пулемёта", "гранатомёта", "дробовика", "игрушечного пистолета", "водяного пистолета")
        @JvmField val withMessages = listOf("мечом", "джедайским мечом", "саблей", "ножом", "алебардой", "линейкой", "бумерангом", "сковородой", "утюгом", "кастрюлей", "ложкой", "вилкой", "гарпуном", "дротиком", "кинжалом", "катаной", "шпагой", "рапирой", "копьём", "мачете", "дубинкой", "карандашом", "бензопилой", "битой", "отвёрткой", "волшебной палочкой", "кулаком", "пальцем", "пулей", "стрелой", "болтом", "топором", "ногтём", "локтём", "ногой", "коленом", "зубами")
        @JvmField val targetMessages = listOf("глаз", "нос", "ухо", "щёку", "рот", "голову", "колено", "лоб", "бровь", "зуб", "подбородок", "шею", "плечо", "спину", "локоть", "руку", "ногу", "палец", "живот", "пупок", "сердце", "печень", "почку", "бедро")
        @JvmField val howMessage = listOf("безжалостно", "свирепо", "люто", "кровожадно", "зверски", "сердито", "бешенно", "исступленно", "разъяренно", "дико", "неистово", "беззаботно", "не глядя", "вслепую", "наобум", "наугад", "вполсилы", "яростно", "без грамма совести", "с радостью", "со злорадством", "элегантно", "изящно", "роскошно", "изысканно", "метко", "стильно", "резко", "сильно", "нагло", "стремительно", "мощно", "быстро", "увесисто", "жестоко", "коварно", "предательски", "мило", "вежливо", "любезно", "деликатно", "приятно", "с любовью", "отчаянно", "шутя", "как боженька", "нежно", "ласково", "аккуратно", "точно", "с гордостью", "с честью", "отважно", "нелепо", "неуклюже", "без сожаления")
        @JvmField val damageMessages = listOf("пожирает", "крадёт", "лайфстилит", "отнимает", "лечит", "растёт на", "восстанавливает", "похищает", "забирает", "высасывает", "поглощает", "ворует", "прикарманивает", "повышается на", "расширяется на", "поправляется на")
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
        try {
            transaction {
                val words = messageEvent.message.split("\\s".toRegex())

                val username = messageEvent.user.name.toLowerCase()
                val userDisplayName = messageEvent.user.displayName!!
                val opponentUsername: String?
                var randomViewer = false
                val channel = Channels.findOrInsert(channelName)

                if (words.size == 1) {
                    opponentUsername = randomViewerExcept(messageEvent, botUsers.plus(username))
                    if (opponentUsername == null) {
                        // TODO: Modify kotlin-twitch-bot and throw an exception instead
                        throw CommandException("Достойных соперников не обнаружено. Kappa")
                    }
                    randomViewer = true
                } else {
                    opponentUsername = words[1].replaceFirst("^@".toRegex(), "").trim().toLowerCase()
                    if (opponentUsername == username) {
                        throw CommandException("Хорошая попытка, $userDisplayName TehePelo")
                    }

                    val leader = channel.duelLeaders.any { it.duelist.user.name == opponentUsername }

                    if (!leader && !viewerOnlineExcept(messageEvent, opponentUsername, botUsers)) {
                        throw CommandException("Пользователь $opponentUsername в чате не найден, или он бот. Kappa")
                    }
                }

                val opponentDisplayName = findDisplayName(opponentUsername)

                var user = Duelists.findOrInsert(Users.findOrInsert(username, userDisplayName), channel)

                if (user.hp <= 0) throw CommandException("Извините, @${user.user.displayName}, но Вы мертвы (${user.hp} хп). BibleThump Вас могут воскресить другие дуэлянты.")
                //if (user.user.name != togepiBotAdmin && user.available?.isAfterNow ?: false) {
                if (user.available?.isAfterNow ?: false) {
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
                        if (initiator) {
                            available = DateTime.now().plusSeconds(calculateCooldown(randomViewer, hp))
                            if (ressurected) resurrects++
                        }
                        winrate = recalculateWinrate()
                    }
                }

                updateDuelist(winner, true)
                updateDuelist(loser, false)

                fun title(duelist: Duelist) = channel.duelTops.filter { it.duelist == duelist && !titlelessUsernames.contains(it.duelist.user.name)}.sortedBy { it.type }.firstOrNull()?.type?.title
                fun displayTitle(duelist: Duelist) : String {
                    val title = title(duelist)
                    return if (title != null) "${title.quotes()} " else ""
                }
                fun displayDuelist(duelist: Duelist) = "${displayTitle(duelist)}@${duelist.user.displayName} (${duelist.hp} хп)"

                sendMessageToChannel(channelName, "/me ${displayDuelist(winner)} ${attackMessage()} ${displayDuelist(loser)} и ${damageMessages.random()} $damageAfterInjury ${hpAliases.random()}. $emote ${crit?.message() ?: ""}${if (killed) " @" + loser.user.displayName + " " + deathMessages.random() + " " + deathEmotes.random() else ""}${if (ressurected) " @" + winner.user.displayName + " " + ressurectMessages.random() + " " + ressurectEmotes.random() else ""}")
            }
        } catch (e: CommandException) {
            sendMessageToChannel(channelName, e.message)
            return
        } catch (e: Exception) {
            logger.error(e) {}
            return
        }
    }

    private fun attackMessage() = when((1..3).toList().random()) {
        1 -> "${howMessage.random()} ${simpleAttackMessages.random()}"
        2 -> "${howMessage.random()} ${doesMessages.random()} ${withMessages.random()} ${targetMessages.random()}"
        3 -> "${howMessage.random()} ${shootMessages.random()} из ${weapons.random()} в ${targetMessages.random()}"
        else -> "${howMessage.random()} ${simpleAttackMessages.random()}"
    }

    fun calculateCooldown(randomViewer: Boolean, hp: Int): Int {
        val baseCooldown = if (randomViewer) cooldownForRandom else cooldownForSpecific
        val cooldown = baseCooldown + ((hp - initialHP) * cooldownHpFactor).roundToInt()
        return cooldown
    }

    // TODO: Move to an extension function to a class Command in kotlin-twitch-bot
    private fun findDisplayName(username: String): String {
        val user = twitchClient.userEndpoint.getUserByUserName(username)
        return if (user.isPresent) user.get().displayName else username
    }
}