package com.igorini.togepibot.gui.keyword.film.gameofthrones

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Jon Snow" */
object JonSnowKeyword : Keyword() {
    override fun folder() = "jon-snow"
    override fun voiceRus() = listOf("джон сноу", "джона сноу", "джону сноу", "джоном сноу", "джоне сноу")
    override fun voiceEng() = listOf("jon snow")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("jonsnow")
}
