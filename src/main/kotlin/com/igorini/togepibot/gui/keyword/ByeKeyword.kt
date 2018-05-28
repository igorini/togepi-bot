package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Bye" */
object ByeKeyword : Keyword() {
    override fun folder() = "bye"
    override fun voiceRus() = listOf("всем пока", "покедова", "бай", "до свидания")
    override fun voiceEng() = listOf("bye", "goodbye", "see ya", "until next time")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("bye")
}
