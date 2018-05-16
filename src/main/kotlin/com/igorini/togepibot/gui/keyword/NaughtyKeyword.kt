package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Naughty" */
object NaughtyKeyword : Keyword() {
    override fun folder() = "naughty"
    override fun voiceRus() = listOf("хитрый", "шаловливый", "хитро", "хитрость", "хитрого", "хитрому", "хитрым", "хитром", "хитрая", "хитрой", "хитрую", "хитрое", "хитрые", "хитрых", "хитрым", "хитрыми", "хитрых", "хитра", "хитры", "хитер", "шалун", "шалунишка", "шали", "шалите", "шалунья")
    override fun voiceEng() = listOf("naughty", "cheeky")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("naughty")
}
