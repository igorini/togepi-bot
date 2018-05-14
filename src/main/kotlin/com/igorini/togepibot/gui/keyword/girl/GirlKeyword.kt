package com.igorini.togepibot.gui.keyword.girl

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Girl" */
object GirlKeyword : Keyword() {
    override fun folder() = "girl"
    override fun voiceRus() = listOf("девушка", "девушки", "девушке", "девушку", "девушкой", "девушек", "девушкам", "девушках", "женщина", "женщины", "женщине", "женщину", "женщиной", "женщин", "женщинами", "женщинах", "девочка", "девочки", "девочке", "девочку", "девочкой", "девочек", "девочкам", "девочками", "девочках", "леди", "мадам", "девчонка", "девчонки", "девчонке", "девчонку", "девчонкой", "девчонок", "девчонкам", "девчонками", "девчонках", "сеньорита", "дама", "дамы", "даме", "даму", "дамой", "дамы", "дамам", "дамами", "дамах", "барышня", "барышни", "барышню", "барышень", "барышней", "барышне", "барышням", "барышнями", "барышнях", "чикса")
    override fun voiceEng() = listOf("girl", "girls", "woman", "women", "lady", "ladies", "female")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("girl")
}
