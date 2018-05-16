package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Oops" */
object OopsKeyword : Keyword() {
    override fun folder() = "oops"
    override fun voiceRus() = listOf("упс", "упсь")
    override fun voiceEng() = listOf("oops", "oopsie")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("oops")
}