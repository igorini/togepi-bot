package com.igorini.togepibot.gui.keyword.anime

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "JoJo" */
object JoJoKeyword : Keyword() {
    override fun folder() = "anime\\jojo"
    override fun voiceRus() = listOf("джоджо")
    override fun voiceEng() = listOf("jojo")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("jojo")
}