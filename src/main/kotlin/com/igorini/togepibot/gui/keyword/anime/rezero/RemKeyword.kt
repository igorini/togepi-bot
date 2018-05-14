package com.igorini.togepibot.gui.keyword.anime.rezero

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Rem" */
object RemKeyword : Keyword() {
    override fun folder() = "anime\\re-zero\\rem"
    override fun voiceRus() = listOf("рем", "рэм")
    override fun voiceEng() = listOf("rem")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("rem")
}