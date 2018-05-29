package com.igorini.togepibot.gui.keyword.film

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Breaking Bad" */
object BreakingBadKeyword : Keyword() {
    override fun folder() = "film\\breaking-bad"
    override fun voiceRus() = listOf("во все тяжкие")
    override fun voiceEng() = listOf("breaking bad")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("breakingbad")
}
