package com.igorini.togepibot.gui.keyword.drink.alcohol

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Wine" */
object WineKeyword : Keyword() {
    override fun folder() = "drink\\alcohol\\wine"
    override fun voiceRus() = listOf("вино", "вином", "винам", "винами")
    override fun voiceEng() = listOf("wine", "wines")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("wine")
}
