package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Awkward" */
object AwkwardKeyword : Keyword() {
    override fun folder() = "awkward"
    override fun voiceRus() = listOf("неловко", "неловкий", "неловкость", "неловкого", "неловкому", "неловким", "неловком", "неловкая", "неловкой", "неловкую", "неловкое", "неловким", "неловких", "неловкими", "неловки")
    override fun voiceEng() = listOf("awkward")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("awkward")
}
