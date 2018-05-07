package com.igorini.togepibot.gui.controllers

import com.igorini.togepibot.gui.keyword.DefaultKeyword
import com.igorini.togepibot.gui.keyword.HelloKeyword
import com.igorini.togepibot.gui.keyword.SarcasmKeyword
import com.igorini.togepibot.gui.views.TogepiView
import javafx.scene.image.Image
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import tornadofx.*
import java.io.File

/** Represents */
class TogepiController : Controller() {

    companion object {
        @JvmField val probePeriodMs = 500L
        @JvmField val sameImageMaxDurationMs = 5000L
    }

    val togepiView: TogepiView by inject()
    val keywords = listOf(HelloKeyword, SarcasmKeyword)

    fun init() {
        recogniseSpeech()
    }

    fun recogniseSpeech() {
        launch {
            val clipboardHistory = File("\\\\DESKTOP-STPM363\\shared\\clipboard.txt")
            var prevClipboard = ""
            var sameImageDurationMs = 0L
            while (true) {
               delay(probePeriodMs)
                val clipboard = clipboardHistory.readLines().lastOrNull()
                if (clipboard != null && (clipboard != prevClipboard || sameImageDurationMs >= sameImageMaxDurationMs)) {
                    println(clipboard)
                    prevClipboard = clipboard!!
                    sameImageDurationMs = 0L
                    togepiView.imageView.image = Image(recogniseKeyword(clipboard.toLowerCase()).imageUrl(), TogepiView.prefWidth, TogepiView.prefHeight, true, true)
                } else {
                    sameImageDurationMs += probePeriodMs
                }
            }
        }
    }

    fun recogniseKeyword(text: String) = keywords.firstOrNull { it.voiceAliases().any { text.contains(it) } } ?: DefaultKeyword
}