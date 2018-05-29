package com.igorini.togepibot.gui.keyword.film

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Saw the Movie" */
object SawKeyword : Keyword() {
    override fun folder() = "film\\saw"
    override fun voiceRus() = listOf("фильм пила")
    override fun voiceEng() = listOf("saw the movie")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("sawthemovie")
}
