package com.igorini.togepibot.gui.keyword.music

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Guitar" */
object GuitarKeyword : Keyword() {
    override fun folder() = "music\\guitar"
    override fun voiceRus() = listOf("гитара", "гитары", "гитаре", "гитару", "гитарой", "гитар", "гитарам", "гитарами", "гитарах")
    override fun voiceEng() = listOf("guitar", "guitars")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("guitar")
}
