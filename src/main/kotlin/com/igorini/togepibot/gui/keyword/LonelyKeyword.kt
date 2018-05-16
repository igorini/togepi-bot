package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Lonely" */
object LonelyKeyword : Keyword() {
    override fun folder() = "lonely"
    override fun voiceRus() = listOf("одинико", "одиночество", "одинокий", "одинокого", "одинокому", "одиноким", "одиноком", "одинок", "одинок", "одиноки", "одинокая", "одинокой", "одинокую", "одинокое", "одинокие", "одиноких", "одиноким", "одинокими")
    override fun voiceEng() = listOf("lonely", "alone", "loneliness")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("lonely")
}
