package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Not Bad" */
object NotBadKeyword : Keyword() {
    override fun folder() = "not-bad"
    override fun voiceRus() = listOf("неплохо", "недурно", "неплохой", "неплохого", "неплохому", "неплохим", "неплохом", "неплохая", "неплохую", "неплохое", "неплохие", "неплохих", "неплохим", "неплохими", "неплох", "неплоха", "неплохи")
    override fun voiceEng() = listOf("not bad")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("notbad")
}
