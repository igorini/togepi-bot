package com.igorini.togepibot.gui.keyword.anime

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Evangelion" */
object EvangelionKeyword : Keyword() {
    override fun folder() = "anime\\evangelion"
    override fun voiceRus() = listOf("евангелион")
    override fun voiceEng() = listOf("evangelion")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("evangelion")
}
