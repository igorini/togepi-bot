package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Cool" */
object CoolKeyword : Keyword() {
    override fun folder() = "cool"
    override fun voiceRus() = listOf("круто", "крутой", "зачмечательно", "крутая", "крутые")
    override fun voiceEng() = listOf("cool")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("coolcat")
}
