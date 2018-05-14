package com.igorini.togepibot.gui.keyword.food

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Ice Cream" */
object IceCreamKeyword : Keyword() {
    override fun folder() = "food\\ice-cream"
    override fun voiceRus() = listOf("мороженое", "пломбир", "эскимо", "морожко", "морожка")
    override fun voiceEng() = listOf("ice cream")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("icecream")
}
