package com.igorini.togepibot.gui.keyword.cartoon

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Cartoon" */
object CartoonKeyword : Keyword() {
    override fun folder() = "cartoon"
    override fun voiceRus() = listOf("мультик", "мультику", "мультиком", "мультике", "мультики", "мультикам", "мультиками", "мультиках", "мультфильм", "мультфильму", "мультфильмом", "мульфильме", "мультфильмы", "мультфильмам", "мультфильмами", "мультфильмах")
    override fun voiceEng() = listOf("cartoon", "cartoons")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("cartoon")
}
