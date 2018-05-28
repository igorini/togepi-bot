package com.igorini.togepibot.gui.keyword.game

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Witcher" */
object WitcherKeyword : Keyword() {
    override fun folder() = "game\\witcher"
    override fun voiceRus() = listOf("ведьмак", "ведьмаку", "ведьмака", "ведьмаки", "ведьмаком", "ведьмаках", "гвинт", "гвент", "гвинту", "гвинте")
    override fun voiceEng() = listOf("gwent", "witcher")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("mitthuma")
}