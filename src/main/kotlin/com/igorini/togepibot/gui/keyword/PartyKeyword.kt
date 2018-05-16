package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Party" */
object PartyKeyword : Keyword() {
    override fun folder() = "aga"
    override fun voiceRus() = listOf("пати", "вечеринка", "вечеринку", "вечеринки", "тусовка", "тусим", "тусуемся", "тусовки", "тусы", "тусовке")
    override fun voiceEng() = listOf("party", "parties", "partying")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("party")
}
