package com.igorini.togepibot.gui.keyword.drink

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Drink" */
object DrinkKeyword : Keyword() {
    override fun folder() = "drink"
    override fun voiceRus() = listOf("пить", "пил", "пило", "пив", "пивши", "пъешь", "пьет", "пьем", "пьете", "пьют", "пей", "пейте", "пью", "напиток", "напитка", "напитку", "напитком", "напитке", "напитки", "напитков", "напиткам", "напитками", "напитках")
    override fun voiceEng() = listOf("drink", "drank", "drunk")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("drink")
}