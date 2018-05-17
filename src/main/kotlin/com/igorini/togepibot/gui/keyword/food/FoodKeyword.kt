package com.igorini.togepibot.gui.keyword.food

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Food" */
object FoodKeyword : Keyword() {
    override fun folder() = "food"
    override fun voiceRus() = listOf("еда", "еды", "еде", "едой", "еде", "завтрак", "завтрака", "завтраку", "завтраком", "завтраке", "обед", "обеда", "обеду", "обедом", "обеде", "ужин", "ужина", "ужину", "ужином", "ужине")
    override fun voiceEng() = listOf("food", "breakfast", "lunch", "dinner")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("nomnom", "doritoschip")
}