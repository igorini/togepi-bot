package com.igorini.togepibot.gui.keyword.film

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "American Horror Story" */
object AmericanHorrorStoryKeyword : Keyword() {
    override fun folder() = "film\\american-horror-story"
    override fun voiceRus() = listOf("американская история ужасов", "американскую историю ужасов")
    override fun voiceEng() = listOf("ahs", "american horror story")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("ahs")
}
