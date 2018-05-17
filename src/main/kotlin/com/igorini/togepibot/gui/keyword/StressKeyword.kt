package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Stress" */
object StressKeyword : Keyword() {
    override fun folder() = "stress"
    override fun voiceRus() = listOf("стресс", "стрессом", "стрессовый", "стрессовая")
    override fun voiceEng() = listOf("stress", "stressed")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("stress")
}