package com.igorini.togepibot.gui.keyword.food

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Kotletki" */
object KotletkiKeyword : Keyword() {
    override fun folder() = "food\\kotletki"
    override fun voiceRus() = listOf("котлета", "котлеты", "котлету", "котлете", "котлетой", "котлет", "котлетах", "котлетка", "котлетки", "пюрешка", "пюрешкой", "пюрешки")
    override fun voiceEng() = listOf("cutlet")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("cutlet")
}
