package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Milena" */
object MilenaKeyword : Keyword() {
    override fun folder() = "milena"
    override fun voiceRus() = listOf("милена", "милены", "милене", "милену", "миленой")
    override fun voiceEng() = listOf("milena")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("milena")
}