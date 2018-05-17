package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Thanks" */
object ThanksKeyword : Keyword() {
    override fun folder() = "thanks"
    override fun voiceRus() = listOf("спасибо", "спасибки", "благодарю", "спасибочки", "сяп", "спс")
    override fun voiceEng() = listOf("thanks", "ty", "thank")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("thanks")
}
