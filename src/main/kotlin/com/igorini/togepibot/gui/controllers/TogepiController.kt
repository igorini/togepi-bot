package com.igorini.togepibot.gui.controllers

import com.google.common.collect.HashMultiset
import com.google.common.collect.Multiset
import com.google.common.collect.Multisets
import com.igorini.togepibot.TogepiBot.Companion.botUsers
import com.igorini.togepibot.gui.views.TogepiView
import javafx.scene.image.Image
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import mu.KotlinLogging
import tornadofx.*
import java.io.File
import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.Multimap
import com.igorini.togepibot.ext.containsConsecutive
import com.igorini.togepibot.ext.random
import com.igorini.togepibot.gui.keyword.*
import com.igorini.togepibot.gui.keyword.animal.*
import com.igorini.togepibot.gui.keyword.anime.*
import com.igorini.togepibot.gui.keyword.anime.deathnote.DeathNoteKeyword
import com.igorini.togepibot.gui.keyword.anime.dokidoki.MonikaKeyword
import com.igorini.togepibot.gui.keyword.anime.naruto.NarutoKeyword
import com.igorini.togepibot.gui.keyword.anime.pokemon.PikachuKeyword
import com.igorini.togepibot.gui.keyword.anime.pokemon.PokemonKeyword
import com.igorini.togepibot.gui.keyword.anime.pokemon.SnorlaxKeyword
import com.igorini.togepibot.gui.keyword.anime.rezero.RemKeyword
import com.igorini.togepibot.gui.keyword.anime.touhou.CirnoKeyword
import com.igorini.togepibot.gui.keyword.cartoon.CartoonKeyword
import com.igorini.togepibot.gui.keyword.cartoon.PonyKeyword
import com.igorini.togepibot.gui.keyword.cook.CookKeyword
import com.igorini.togepibot.gui.keyword.cook.PanKeyword
import com.igorini.togepibot.gui.keyword.drink.DrinkKeyword
import com.igorini.togepibot.gui.keyword.drink.TeaKeyword
import com.igorini.togepibot.gui.keyword.drink.alcohol.AlcoholKeyword
import com.igorini.togepibot.gui.keyword.drink.alcohol.BeerKeyword
import com.igorini.togepibot.gui.keyword.film.*
import com.igorini.togepibot.gui.keyword.film.gameofthrones.GameOfThronesKeyword
import com.igorini.togepibot.gui.keyword.film.gameofthrones.JonSnowKeyword
import com.igorini.togepibot.gui.keyword.food.FoodKeyword
import com.igorini.togepibot.gui.keyword.food.IceCreamKeyword
import com.igorini.togepibot.gui.keyword.food.KotletkiKeyword
import com.igorini.togepibot.gui.keyword.food.PastaKeyword
import com.igorini.togepibot.gui.keyword.game.DetroitBecomeHumanKeyword
import com.igorini.togepibot.gui.keyword.game.OverwatchKeyword
import com.igorini.togepibot.gui.keyword.game.SkyrimKeyword
import com.igorini.togepibot.gui.keyword.game.WitcherKeyword
import com.igorini.togepibot.gui.keyword.girl.GirlBlondeHairKeyword
import com.igorini.togepibot.gui.keyword.girl.GirlKeyword
import com.igorini.togepibot.gui.keyword.girl.GirlRedHairKeyword
import com.igorini.togepibot.gui.keyword.good.GoodKeyword
import com.igorini.togepibot.gui.keyword.good.OkKeyword
import com.igorini.togepibot.gui.keyword.guy.BeardGuyKeyword
import com.igorini.togepibot.gui.keyword.guy.BrunetKeyword
import com.igorini.togepibot.gui.keyword.guy.GuyKeyword
import com.igorini.togepibot.gui.keyword.music.DrumsKeyword
import com.igorini.togepibot.gui.keyword.music.GuitarKeyword
import com.igorini.togepibot.gui.keyword.music.MusicKeyword
import com.igorini.togepibot.gui.keyword.person.actor.BradPittKeyword
import com.igorini.togepibot.gui.keyword.person.actor.EvaGreenKeyword
import com.igorini.togepibot.gui.keyword.person.actor.KeanuReevesKeyword
import com.igorini.togepibot.gui.keyword.person.actor.NicolasCageKeyword
import com.igorini.togepibot.gui.keyword.weather.ColdKeyword
import com.igorini.togepibot.gui.keyword.weather.HotKeyword
import com.igorini.togepibot.gui.keyword.weather.RainKeyword
import com.igorini.togepibot.gui.keyword.weather.WeatherKeyword
import javafx.scene.media.AudioClip
import org.joda.time.DateTime

/** Represents */
class TogepiController : Controller() {
    companion object {
        @JvmField val probePeriodMs = 500L
        @JvmField val sameImageMinDurationMs = 2000L
        @JvmField val sameImageMaxDurationMs = 10000L
        @JvmField val chatBufferMaxDurationMs = 3000L
        @JvmField val interestImageCooldownMs = 30000L

        @Volatile var userMessagesBuffer: Multimap<String, String> = ArrayListMultimap.create()
    }

    val logger = KotlinLogging.logger {}
    val togepiView: TogepiView by inject()
    val keywords = listOf(TrueDetectiveKeyword, BreakingBadKeyword, BladeRunnerKeyword, PennyDreadfulKeyword, PastaKeyword, MiddleKeyword, FriendsKeyword, HowlsMovingCastleKeyword, SkyrimKeyword, OverwatchKeyword, BradPittKeyword, OneHundredKeyword, SailorMoonKeyword, SawKeyword, DetroitBecomeHumanKeyword, KotletkiKeyword, FateStayNightKeyword, AmericanHorrorStoryKeyword, RipperStreetKeyword, EvangelionKeyword, JoJoKeyword, DikiyAngelKeyword, EvaGreenKeyword, CirnoKeyword, BeardGuyKeyword, DeathNoteKeyword, MoniaKeyword, MilenaKeyword, BeerKeyword, WitcherKeyword, WinkKeyword, JonSnowKeyword, MonikaKeyword, KeanuReevesKeyword, PikachuKeyword, SnorlaxKeyword, RemKeyword, NicolasCageKeyword, NarutoKeyword, GintamaKeyword, SteinsGateKeyword, SquirrelKeyword, DogKeyword, CatKeyword, PonyKeyword, PanKeyword, GameOfThronesKeyword, AlcoholKeyword, TeaKeyword, IceCreamKeyword, GirlBlondeHairKeyword, GirlRedHairKeyword, BrunetKeyword, RainKeyword, PokemonKeyword, ColdKeyword, HotKeyword, OkKeyword, DrumsKeyword, GuitarKeyword, AngelKeyword, ChoiceKeyword, DrinkKeyword, CartoonKeyword, AnimalKeyword, GetWellKeyword, HeartKeyword, AnimeKeyword, CookKeyword, FoodKeyword, FilmKeyword, MusicKeyword, WeatherKeyword, FastKeyword, CrazyKeyword, GirlKeyword, GuyKeyword, BloodKeyword, DefeatKeyword, FatKeyword, GiftKeyword, ConfusedKeyword, FightKeyword, FlatteredKeyword, FlirtKeyword, FriendKeyword, GoodLuckKeyword, ByeKeyword, LittleBoyKeyword, LittleGirlKeyword, LonelyKeyword, AwkwardKeyword, BoredKeyword, CuteKeyword, RaccoonKeyword, AnnoyedKeyword, HugKeyword, HappyKeyword, HungryKeyword, InnocentKeyword, KissKeyword, LazyKeyword, MoneyKeyword, NaughtyKeyword, NervousKeyword, NoKeyword, ObidaKeyword, OohKeyword, OopsKeyword, PainKeyword, PaperKeyword, PartyKeyword, PhoneKeyword, PleaseKeyword, QuietKeyword, ReadKeyword, SadKeyword, SalivaKeyword, ScaredKeyword, ScreamKeyword, SexyKeyword, ShameKeyword, ShockKeyword, ShyKeyword, SiblingKeyword, SleepyKeyword, SmartKeyword, SneakKeyword, SorryKeyword, StressKeyword, SuspiciousKeyword, SweatKeyword, TeaseKeyword, ThanksKeyword, TiredKeyword, ToEatKeyword, ToLeaveKeyword, ToRunKeyword, ToSmokeKeyword, ToThinkKeyword, ToTypeKeyword, VictoryKeyword, WaitKeyword, WakeUpKeyword, WellDoneKeyword, WinkKeyword, AngryKeyword, ExcitedKeyword, BeggingKeyword, NotBadKeyword, CryKeyword, CoolKeyword, DanceKeyword, SarcasmKeyword, MonkasKeyword, HelloKeyword, GoodKeyword, LoveKeyword, LaughKeyword, AgaKeyword)
    val interestKeywords = listOf(TrueDetectiveKeyword, BreakingBadKeyword, BladeRunnerKeyword, PennyDreadfulKeyword, PastaKeyword, MiddleKeyword, FriendsKeyword, HowlsMovingCastleKeyword, SkyrimKeyword, OverwatchKeyword, BradPittKeyword, OneHundredKeyword, SailorMoonKeyword, SawKeyword, DetroitBecomeHumanKeyword, RaccoonKeyword, KotletkiKeyword, CatKeyword, DogKeyword, SquirrelKeyword, RaccoonKeyword, FateStayNightKeyword, AmericanHorrorStoryKeyword, RipperStreetKeyword, GintamaKeyword, GameOfThronesKeyword, JoJoKeyword, DikiyAngelKeyword, SteinsGateKeyword, WitcherKeyword, PikachuKeyword, EvaGreenKeyword, DeathNoteKeyword, KeanuReevesKeyword, MonikaKeyword, CatKeyword, NarutoKeyword, DogKeyword, PokemonKeyword, SquirrelKeyword, RemKeyword, EvangelionKeyword, CirnoKeyword, SnorlaxKeyword)
    val clipboardHistory = File("\\\\DESKTOP-STPM363\\shared\\clipboard.txt")
    var soundOnGlobalCooldownUntil: DateTime? = null

    fun init() {
        listenForKeywords()
    }

    fun listenForKeywords() {

        launch {
            var prevClipboard = ""
            var sameImageDurationMs = 0L
            var chatBufferDurationMs = 0L
            var timeSinceLastInterestImageMs = 0L
            var clipboard = ""

            fun recogniseChatKeyword(text: String): Keyword? {
                logger.trace { "Text to recognise: $text" }
                val words = text.toLowerCase().replace('ё', 'e').split("\\P{L}+".toRegex())
                logger.trace { "Words to recognise: $words" }
                return keywords.firstOrNull { it.text().any { words.containsConsecutive(it) } }
            }

            fun recogniseVoiceKeyword(text: String): Keyword? {
                val words = text.toLowerCase().replace('ё', 'e').split("\\P{L}+".toRegex())
                return keywords.firstOrNull { it.voice().any { words.containsConsecutive(it) } }
            }

            fun mostCommonChatKeyword(): Keyword? {
                val chatKeywords: Multiset<Keyword> = HashMultiset.create()
                logger.trace { "Chat buffer: $userMessagesBuffer" }
                userMessagesBuffer.asMap().filterKeys { !botUsers.contains(it) }.values.flatten().map { recogniseChatKeyword(it) }.filterNotNull().forEach { chatKeywords.add(it) }

                if (chatKeywords.isEmpty()) return null

                logger.info { "Chat Keywords: $chatKeywords" }
                return Multisets.copyHighestCountFirst(chatKeywords).elementSet().iterator().next()
            }

            fun recogniseKeyword(): Keyword? {
                var keyword: Keyword? = null

                if (!clipboard.isBlank() && clipboard != prevClipboard) {
                    logger.info("New clipboard text: $clipboard")
                    prevClipboard = clipboard
                    keyword = recogniseVoiceKeyword(clipboard.toLowerCase())
                }

                if (keyword != null) return keyword

                val mostCommonChatKeyword =  mostCommonChatKeyword()
                mostCommonChatKeyword?.let { logger.info { "Most common chat keyword: ${mostCommonChatKeyword.folder()}" } }

                return mostCommonChatKeyword
            }

            fun updateImage(keyword: Keyword) {
                sameImageDurationMs = 0L
                val imageUrl = keyword.imageUrl()
                imageUrl?.let {
                    togepiView.imageView.image = Image(imageUrl, TogepiView.prefWidth, TogepiView.prefHeight, true, true)
                }
                keyword.soundUrl()?.let {
                    val notOnGlobalCooldown = soundOnGlobalCooldownUntil?.isBeforeNow ?: true
                    val notOnKeywordCooldown = keyword.soundOnCooldownUntil?.isBeforeNow ?: true
                    if (notOnGlobalCooldown && notOnKeywordCooldown) {
                        keyword.soundOnCooldownUntil = DateTime.now().plusSeconds(keyword.soundCooldownSec)
                        soundOnGlobalCooldownUntil = DateTime.now().plusSeconds(Keyword.globalSoundCooldownSec)
                        AudioClip(it).play(keyword.soundVolume)
                    }
                }
            }

            while (true) {
                delay(probePeriodMs)
                sameImageDurationMs += probePeriodMs
                chatBufferDurationMs += probePeriodMs
                timeSinceLastInterestImageMs += probePeriodMs

                clipboard = clipboardHistory.readLines().last()
                if (sameImageDurationMs >= sameImageMinDurationMs) {
                    val forceUpdate = sameImageDurationMs >= sameImageMaxDurationMs
                    if (forceUpdate) {
                        if (timeSinceLastInterestImageMs >= interestImageCooldownMs) {
                            updateImage(interestKeywords.random())
                            timeSinceLastInterestImageMs = 0L
                        } else {
                            updateImage(DefaultKeyword)
                        }
                    } else {
                        val keyword = recogniseKeyword()
                        if (keyword != null) updateImage(keyword)
                    }
                }

                if (chatBufferDurationMs >= chatBufferMaxDurationMs) {
                    userMessagesBuffer.clear()
                    chatBufferDurationMs = 0L
                }
            }
        }
    }
}