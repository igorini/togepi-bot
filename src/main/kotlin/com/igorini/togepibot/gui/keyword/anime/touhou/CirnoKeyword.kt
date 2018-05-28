package com.igorini.togepibot.gui.keyword.anime.touhou

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Cirno" */
object CirnoKeyword : Keyword() {
    override fun folder() = "anime\\touhou\\cirno"
    override fun voiceRus() = listOf("сирно", "чирно", "цирно")
    override fun voiceEng() = listOf("cirno")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("cirno")
}