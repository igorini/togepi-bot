package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Monia" */
object MoniaKeyword : Keyword() {
    override fun folder() = "monia"
    override fun voiceRus() = listOf("моня")
    override fun voiceEng() = listOf("monia")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("monia")
}
