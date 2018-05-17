package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Tired" */
object TiredKeyword : Keyword() {
    override fun folder() = "tired"
    override fun voiceRus() = listOf("уставать", "устал", "утомило", "утомился", "утомилась", "устала", "усталый", "усталая", "устали")
    override fun voiceEng() = listOf("tired")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("tired")
}
