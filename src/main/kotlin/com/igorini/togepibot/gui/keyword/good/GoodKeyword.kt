package com.igorini.togepibot.gui.keyword.good

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Good" */
object GoodKeyword : Keyword() {
    override fun folder() = "good"
    override fun voiceRus() = listOf("хорошо", "хороший", "хорошего", "хорошим", "хорошем", "хорошая", "хорошей", "хорошую", "хорошее", "хороших", "хорошим", "хороши", "хороше", "отлично", "отличный", "отличного", "отлшичному", "отличным", "отличном", "отличная", "отличной", "отличную", "отличное", "отличного", "отличному", "отличным", "отличные", "отличных", "отличен", "блеск", "замечательно", "чудно", "тип-топ", "ништяк", "неормалек", "ладушки", "классно")
    override fun voiceEng() = listOf("good", "excellent", "wonderful")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("feelsgoodman")
}
