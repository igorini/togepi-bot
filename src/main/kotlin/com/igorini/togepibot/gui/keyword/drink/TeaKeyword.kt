package com.igorini.togepibot.gui.keyword.drink

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Tea/Coffee" */
object TeaKeyword : Keyword() {
    override fun folder() = "drink\\tea"
    override fun voiceRus() = listOf("чай", "чая", "чаю", "чаем", "чае", "чаи", "чаев", "чаям", "чаями", "чаях", "чаек", "чайку", "чайком", "кофе")
    override fun voiceEng() = listOf("tea", "coffee")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("tpfufun")
}