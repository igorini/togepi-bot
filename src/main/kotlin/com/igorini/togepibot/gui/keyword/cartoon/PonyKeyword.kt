package com.igorini.togepibot.gui.keyword.cartoon

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "My Little Pony" */
object PonyKeyword : Keyword() {
    override fun folder() = "cartoon\\pony"
    override fun voiceRus() = listOf("пони")
    override fun voiceEng() = listOf("pony")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("pony")
}
