package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Hungry" */
object HungryKeyword : Keyword() {
    override fun folder() = "hungry"
    override fun voiceRus() = listOf("голодать", "голодный", "голодного", "голодному", "голодным", "голодном", "голодные", "голодных", "голодным", "голодными", "голодное", "голодная", "голодной", "голодную", "проголодавлся", "проголодалась", "аппетитно", "аппетитный")
    override fun voiceEng() = listOf("hungry")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("hungry")
}
