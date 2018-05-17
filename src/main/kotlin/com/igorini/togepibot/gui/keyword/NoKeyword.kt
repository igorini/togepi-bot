package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "No" */
object NoKeyword : Keyword() {
    override fun folder() = "no"
    override fun voiceRus() = listOf("нет", "неа")
    override fun voiceEng() = listOf("no", "nope", "none", "nay")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("votenay")
}