package com.igorini.togepibot.gui.keyword.anime.naruto

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Naruto" */
object NarutoKeyword : Keyword() {
    override fun folder() = "anime\\naruto"
    override fun voiceRus() = listOf("наруто")
    override fun voiceEng() = listOf("naruto")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("naruto")
}