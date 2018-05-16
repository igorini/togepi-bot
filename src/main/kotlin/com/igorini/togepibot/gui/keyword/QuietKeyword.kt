package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Quiet" */
object QuietKeyword : Keyword() {
    override fun folder() = "quiet"
    override fun voiceRus() = listOf("тихо", "тихий", "тихому", "тихого", "тихим", "тихом", "тихая", "тихой", "тихую", "тихое", "тихие", "притих", "притихла", "тихих", "тихим", "тихими", "тих", "тиха")
    override fun voiceEng() = listOf("quiet", "quietly")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("quiet")
}
