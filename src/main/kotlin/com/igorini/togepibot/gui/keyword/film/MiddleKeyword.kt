package com.igorini.togepibot.gui.keyword.film

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "The Middle" */
object MiddleKeyword : Keyword() {
    override fun folder() = "film\\middle"
    override fun voiceRus() = listOf("бывает и хуже")
    override fun voiceEng() = listOf("the middle")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("the middle")
}
