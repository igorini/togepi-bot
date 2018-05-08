package com.igorini.togepibot.gui.keyword

import com.igorini.togepibot.ext.random
import java.io.File

/** Represents */
abstract class Keyword {
    val images by lazy {
        File("$rootFolder${folder()}").walk().filter { it.isFile }.map { it.toURI().toURL().toExternalForm() }.toList()
    }

    companion object {
        const val rootFolder = "C:\\dev\\repos\\togepi-bot\\src\\main\\resources\\images\\"
    }

    abstract fun folder(): String
    abstract fun voiceRus(): List<String>
    abstract fun voiceEng(): List<String>
    abstract fun textRus(): List<String>
    abstract fun textEng(): List<String>
    abstract fun emotes(): List<String>

    fun imageUrl() = images.random()
    fun voice() = voiceRus() + voiceEng()
    fun text() = textRus() + textEng() + emotes()
}