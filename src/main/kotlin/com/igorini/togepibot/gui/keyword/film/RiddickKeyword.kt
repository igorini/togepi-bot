package com.igorini.togepibot.gui.keyword.film

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Riddick" */
object RiddickKeyword : Keyword() {
    override fun folder() = "film\\riddick"
    override fun voiceRus() = listOf("риддик", "риддике", "риддику", "риддика", "риддики", "ридик")
    override fun voiceEng() = listOf("riddick")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("riddick")
}
