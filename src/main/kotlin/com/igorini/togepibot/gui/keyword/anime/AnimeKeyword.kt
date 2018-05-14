package com.igorini.togepibot.gui.keyword.anime

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Anime" */
object AnimeKeyword : Keyword() {
    override fun folder() = "anime"
    override fun voiceRus() = listOf("аниме", "анимешка", "анимешку", "анимешке", "анимешки", "анимешек", "анимешках", "анимешный", "анимешная", "анимешную", "анимешные")
    override fun voiceEng() = listOf("anime")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("anime")
}