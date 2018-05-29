package com.igorini.togepibot.gui.keyword.anime

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Sailor Moon" */
object SailorMoonKeyword : Keyword() {
    override fun folder() = "anime\\sailor-moon"
    override fun voiceRus() = listOf("сейлормун", "сейлор мун")
    override fun voiceEng() = listOf("sailor moon")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("sailormoon")
}
