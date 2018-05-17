package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Tease" */
object TeaseKeyword : Keyword() {
    override fun folder() = "tease"
    override fun voiceRus() = listOf("издеваться", "бм", "издеваюсь", "издеваешься", "издевается", "издеваемся", "издеваетесь", "издеваются", "издевался", "издевалась", "издевались", "издевайся", "издевайтесь", "бмишь", "бмит", "бмил")
    override fun voiceEng() = listOf("tease", "teasing", "bm")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("tease")
}
