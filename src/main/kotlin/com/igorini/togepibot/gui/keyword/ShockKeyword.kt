package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Shock" */
object ShockKeyword : Keyword() {
    override fun folder() = "shock"
    override fun voiceRus() = listOf("шок", "удивительно", "удивлен", "шокирован", "шока", "шоку", "шоком", "шоке", "шоки", "шоков", "шокам", "шоками", "шоках", "шокирующий", "шокирующая", "удивлина", "удивил", "удивила", "поразительно")
    override fun voiceEng() = listOf("shock", "shocked", "shocking")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("shock")
}
