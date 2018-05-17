package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Sexy" */
object SexyKeyword : Keyword() {
    override fun folder() = "sexy"
    override fun voiceRus() = listOf("секси", "сексуальная", "сексуальный", "сексуальные")
    override fun voiceEng() = listOf("sexy")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("sexy")
}
