package com.igorini.togepibot.gui.keyword.film

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Film" */
object FilmKeyword : Keyword() {
    override fun folder() = "film"
    override fun voiceRus() = listOf("фильм", "фильма", "фильму", "фильмом", "фильме", "фильмы", "фильмов", "фильмам", "фильмами", "фильмах", "сериал", "сериала", "сериалу", "сериалом", "сериале", "сериалы", "сериалов", "сериалам", "сериылами", "сериалах")
    override fun voiceEng() = listOf("film", "films", "movie", "movies", "tv series")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("film")
}
