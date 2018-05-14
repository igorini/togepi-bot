package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Yes" */
object PhoneKeyword : Keyword() {
    override fun folder() = "aga"
    override fun voiceRus() = listOf("ага", "агась", "угу")
    override fun voiceEng() = listOf("yes")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("yes")
}
