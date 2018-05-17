package com.igorini.togepibot.gui.keyword.weather

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Hot" */
object HotKeyword : Keyword() {
    override fun folder() = "weather\\hot"
    override fun voiceRus() = listOf("жарко", "жара", "жары", "жаре", "жару", "жарой", "жар", "теплее", "потеплело", "тепло", "тепла", "теплу", "тепле", "теплом", "тепловато", "жарковато", "горячо", "жарища", "жарище", "жарищу")
    override fun voiceEng() = listOf("hot", "warm", "boiling")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("hot")
}
