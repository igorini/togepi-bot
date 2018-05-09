package com.igorini.togepibot.gui.keyword

import com.igorini.togepibot.ext.random
import com.igorini.togepibot.ext.randomOrNull
import org.joda.time.DateTime
import java.io.File

/** Represents */
abstract class Keyword {
    open val soundCooldownSec = 30
    open val soundVolume = 0.5
    open var soundOnCooldownUntil: DateTime? = null

    val images by lazy { File("$rootFolder${folder()}").walk().filter { it.isFile }.map { it.toURI().toURL().toExternalForm() }.toList() }
    val sounds by lazy { File("$rootFolder${soundsFolder()}").walk().filter { it.isFile }.map { it.toURI().toURL().toExternalForm() }.toList() }

    companion object {
        const val rootFolder = "C:\\dev\\repos\\togepi-bot\\src\\main\\resources\\images\\"
        @JvmField val globalSoundCooldownSec = 10
    }

    abstract fun folder(): String
    abstract fun voiceRus(): List<String>
    abstract fun voiceEng(): List<String>
    abstract fun textRus(): List<String>
    abstract fun textEng(): List<String>
    abstract fun emotes(): List<String>

    fun soundsFolder() = "${folder()}\\sound"
    fun imageUrl() = images.random()
    fun soundUrl() = sounds.randomOrNull()
    fun voice() = voiceRus() + voiceEng()
    fun text() = textRus() + textEng() + emotes()
}