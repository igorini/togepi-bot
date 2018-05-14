package com.igorini.togepibot.gui.keyword.drink.alcohol

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Beer" */
object BeerKeyword : Keyword() {
    override fun folder() = "drink\\alcohol\\beer"
    override fun voiceRus() = listOf("пиво", "пмва", "пиву", "пивом", "пиве", "пивко", "пивка", "пивку", "пивке", "пивком", "пивке")
    override fun voiceEng() = listOf("beer")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("beer")
}
