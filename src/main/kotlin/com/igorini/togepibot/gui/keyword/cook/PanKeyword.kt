package com.igorini.togepibot.gui.keyword.cook

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Pan" */
object PanKeyword : Keyword() {
    override fun folder() = "cook\\pan"
    override fun voiceRus() = listOf("сковорода", "сковороды", "сковороде", "сковороду", "сковородой", "сковородка", "сковородки", "сковородке", "сковородку", "сковородкой")
    override fun voiceEng() = listOf("pan", "fryer")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("pan")
}