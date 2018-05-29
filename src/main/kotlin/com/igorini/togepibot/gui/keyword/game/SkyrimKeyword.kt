package com.igorini.togepibot.gui.keyword.game

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Skyrim" */
object SkyrimKeyword : Keyword() {
    override fun folder() = "game\\skyrim"
    override fun voiceRus() = listOf("скайрим", "скайриме", "скайримом", "скайриму")
    override fun voiceEng() = listOf("skyrim")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("skyrim")
}