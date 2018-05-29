package com.igorini.togepibot.gui.keyword.film

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "True Detective" */
object TrueDetectiveKeyword : Keyword() {
    override fun folder() = "film\\true-detective"
    override fun voiceRus() = listOf("настоящий детектив", "настоящего детектива")
    override fun voiceEng() = listOf("true detective")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("truedetective")
}
