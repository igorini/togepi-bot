package com.igorini.togepibot.gui.keyword.anime

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Fate Stay Night" */
object FateStayNightKeyword : Keyword() {
    override fun folder() = "anime\\fate"
    override fun voiceRus() = listOf("судба ночь прибытия")
    override fun voiceEng() = listOf("fate stay night")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("fatestaynight")
}
