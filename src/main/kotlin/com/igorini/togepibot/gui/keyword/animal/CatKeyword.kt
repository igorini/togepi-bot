package com.igorini.togepibot.gui.keyword.animal

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Cat" */
object CatKeyword : Keyword() {
    override fun folder() = "animal\\cat"
    override fun voiceRus() = listOf("кот", "коты", "кота", "коту", "коте", "котам", "котов", "котах", "кошка", "кошку", "кошке", "кошки", "кошках", "кошкам", "котик", "котика", "котику", "котике", "котики", "котикам", "котиков", "котиках", "котейка", "котейке", "котейкой", "котейку", "котейки", "котеек", "котейкам", "котейках", "киска", "киску", "киске", "киской", "киски", "кисок", "кискам", "кисок", "кисками", "кисках", "кот", "котенок", "котенка", "котенку", "котенком", "котенке", "котята", "котят", "котятам", "котятами", "котятах", "мур", "мяу")
    override fun voiceEng() = listOf("cat", "kitten", "cats", "kittens", "meow")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("cat")
}
