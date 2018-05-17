package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Sorry" */
object SorryKeyword : Keyword() {
    override fun folder() = "sorry"
    override fun voiceRus() = listOf("извини", "извините", "прости", "простите", "сорян", "пардон", "виноват", "виновата", "сорри")
    override fun voiceEng() = listOf("sorry")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("sorry")
}