package com.igorini.togepibot.gui.keyword.game

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Overwatch" */
object OverwatchKeyword : Keyword() {
    override fun folder() = "game\\overwatch"
    override fun voiceRus() = listOf("овервотч", "овервоч", "овервотчу", "овервотче", "овервотчи")
    override fun voiceEng() = listOf("overwatch")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("overwatch")
}