package com.igorini.togepibot.gui.keyword

/** Represents a Default keyword */
object DefaultKeyword : Keyword() {
    override fun folder() = "default"
    override fun voiceRus() = emptyList<String>()
    override fun voiceEng() = emptyList<String>()
    override fun textRus() = emptyList<String>()
    override fun textEng() = emptyList<String>()
    override fun emotes() = emptyList<String>()
}