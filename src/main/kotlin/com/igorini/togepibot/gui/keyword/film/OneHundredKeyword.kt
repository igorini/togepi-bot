package com.igorini.togepibot.gui.keyword.film

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "The 100" */
object OneHundredKeyword : Keyword() {
    override fun folder() = "film\\the-100"
    override fun voiceRus() = listOf("сотня", "100")
    override fun voiceEng() = listOf("one hundred")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("onehundred")
}
