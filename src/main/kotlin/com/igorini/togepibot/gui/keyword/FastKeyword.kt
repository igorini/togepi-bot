package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Fast" */
object FastKeyword : Keyword() {
    override fun folder() = "fast"
    override fun voiceRus() = listOf("быстро", "быстрый", "быстрого", "быстрому", "быстрого", "быстрым", "быстром", "быстрая", "быстрой", "быструю", "быстрое", "быстрого", "быстрому", "быстрым", "быстром", "быстрые", "быстрых", "быстрым", "быстрыми", "быстр", "быстра", "фаст", "фастом", "фасту")
    override fun voiceEng() = listOf("fast", "quick", "quickly")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("fast")
}
