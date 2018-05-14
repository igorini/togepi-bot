package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Little Boy" */
object LittleBoyKeyword : Keyword() {
    override fun folder() = "little-boy"
    override fun voiceRus() = listOf("мальчик", "мальчика", "мальчику", "мальчиком", "мальчике", "мальчики", "мальчиков", "мальчикам", "мальчиками", "мальчиках")
    override fun voiceEng() = listOf("little boy")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("littleboy")
}
