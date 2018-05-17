package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "MonkaS" */
object MonkasKeyword : Keyword() {
    override fun folder() = "monkas"
    override fun voiceRus() = listOf("монкас")
    override fun voiceEng() = listOf("monkas")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("monkas")
}
