package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Flattered" */
object FlatteredKeyword : Keyword() {
    override fun folder() = "flattered"
    override fun voiceRus() = listOf("смущаться", "смущаюсь", "смущается")
    override fun voiceEng() = listOf("flatter", "humble", "flattered", "flattering", "humbling")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("flattered")
}
