package com.igorini.togepibot.gui.keyword.anime

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Gintama" */
object GintamaKeyword : Keyword() {
    override val soundVolume: Double
        get() = 0.02

    override fun folder() = "anime\\gintama"
    override fun voiceRus() = listOf("гинтама", "гинтаму", "гинтаме", "гинтамой")
    override fun voiceEng() = listOf("gintama")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("gintama")
}