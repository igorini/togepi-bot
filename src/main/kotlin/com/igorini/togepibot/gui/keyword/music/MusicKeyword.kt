package com.igorini.togepibot.gui.keyword.music

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Music" */
object MusicKeyword : Keyword() {
    override fun folder() = "music"
    override fun voiceRus() = listOf("музыка", "музыки", "музыке", "музыку", "музыкой", "музык", "музыкам", "музыками", "музыках", "мелодия", "мелодии", "мелодию", "мелодией", "мелодий", "мелодиям", "мелодиями", "мелодиях")
    override fun voiceEng() = listOf("music", "melody")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("music")
}
