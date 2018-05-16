package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Paper" */
object PaperKeyword : Keyword() {
    override fun folder() = "paper"
    override fun voiceRus() = listOf("бумага", "бумаги", "бумажка", "бумажки", "бумажный", "бумажная")
    override fun voiceEng() = listOf("paper", "papers")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("paper")
}
