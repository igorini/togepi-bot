package com.igorini.togepibot.gui.controllers

import com.google.common.collect.HashMultiset
import com.google.common.collect.Multiset
import com.google.common.collect.Multisets
import com.igorini.togepibot.TogepiBot.Companion.botUsers
import com.igorini.togepibot.gui.keyword.DefaultKeyword
import com.igorini.togepibot.gui.keyword.HelloKeyword
import com.igorini.togepibot.gui.keyword.Keyword
import com.igorini.togepibot.gui.keyword.SarcasmKeyword
import com.igorini.togepibot.gui.views.TogepiView
import javafx.scene.image.Image
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import mu.KotlinLogging
import tornadofx.*
import java.io.File
import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.Multimap

/** Represents */
class TogepiController : Controller() {
    val logger = KotlinLogging.logger {}

    companion object {
        @JvmField val probePeriodMs = 500L
        @JvmField val sameImageMinDurationMs = 2000L
        @JvmField val sameImageMaxDurationMs = 10000L
        @JvmField val chatBufferMaxDurationMs = 3000L

        @Volatile var userMessagesBuffer: Multimap<String, String> = ArrayListMultimap.create()
    }

    val togepiView: TogepiView by inject()
    val keywords = listOf(HelloKeyword, SarcasmKeyword)
    val clipboardHistory = File("\\\\DESKTOP-STPM363\\shared\\clipboard.txt")

    fun init() {
        listenForKeywords()
    }

    fun listenForKeywords() {
        launch {
            var prevClipboard = ""
            var sameImageDurationMs = 0L
            var chatBufferDurationMs = 0L
            var clipboard = ""

            fun recogniseChatKeyword(text: String): Keyword? {
                logger.trace { "Text to recognise: $text" }
                val words = text.toLowerCase().split("\\P{L}+".toRegex())
                logger.trace { "Words to recognise: $words" }
                return keywords.firstOrNull { it.text().any { words.contains(it) } }
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
                togepiView.imageView.image = Image(keyword.imageUrl(), TogepiView.prefWidth, TogepiView.prefHeight, true, true)
            }

            while (true) {
                delay(probePeriodMs)
                sameImageDurationMs += probePeriodMs
                chatBufferDurationMs += probePeriodMs

                clipboard = clipboardHistory.readLines().last()
                if (sameImageDurationMs >= sameImageMinDurationMs) {
                    val forceUpdate = sameImageDurationMs >= sameImageMaxDurationMs
                    if (forceUpdate) {
                        updateImage(DefaultKeyword)
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

    fun recogniseVoiceKeyword(text: String) = keywords.firstOrNull { it.voice().any { text.contains(it) } }
}