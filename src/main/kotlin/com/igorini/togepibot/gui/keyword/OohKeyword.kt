package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Ooh" */
object OohKeyword : Keyword() {
    override fun folder() = "ooh"
    override fun voiceRus() = listOf("ух", "фьюх", "пронесло")
    override fun voiceEng() = listOf("ooh")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("ooh")
}
