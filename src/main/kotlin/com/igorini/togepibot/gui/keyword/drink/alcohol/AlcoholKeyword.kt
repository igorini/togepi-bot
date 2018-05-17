package com.igorini.togepibot.gui.keyword.drink.alcohol

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Alcohol" */
object AlcoholKeyword : Keyword() {
    override fun folder() = "drink\\alcohol"
    override fun voiceRus() = listOf("алкоголь", "алкогольные", "алкоголи", "алкоголью", "бухло", "бухлу", "бухла", "бухлом", "алкострим", "бухлострим", "алкострима", "бухлострима", "напиваться", "напиться")
    override fun voiceEng() = listOf("alcohol")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("hscheers")
}
