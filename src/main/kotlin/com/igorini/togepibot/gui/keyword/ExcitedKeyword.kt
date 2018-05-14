package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Excited" */
object ExcitedKeyword : Keyword() {
    override fun folder() = "excited"
    override fun voiceRus() = listOf("восторге", "восторг", "восторга", "восторгу", "восторгом", "восторженно")
    override fun voiceEng() = listOf("excited")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("pogchamp")
}
