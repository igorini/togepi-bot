package com.igorini.togepibot.gui.keyword.guy

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Guy" */
object GuyKeyword : Keyword() {
    override fun folder() = "guy"
    override fun voiceRus() = listOf("мужчина", "мужчины", "мужчине", "мужчину", "мужчиной", "мужчин", "мужчинам", "мужчинами", "мужчинах", "парень", "парня", "парню", "парнем", "парне", "парни", "парней", "парням", "парнями", "парнях", "пацан", "пацана", "пацану", "пацаном", "пацане", "пацаны", "посоны", "пацанов", "пацанам", "пацанами", "пацанах", "юноша", "паренек", "юнец", "молодой человек")
    override fun voiceEng() = listOf("man", "guy", "dude", "folk")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("guy")
}
