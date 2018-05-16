package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Innocent" */
object InnocentKeyword : Keyword() {
    override fun folder() = "innocent"
    override fun voiceRus() = listOf("это не я", "невинный", "не виноват", "не виновата", "невинного", "невинному", "невинным", "невинном", "невинная", "невинной", "невинную", "невинные", "невинных", "невинными")
    override fun voiceEng() = listOf("innocent")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("innocent")
}
