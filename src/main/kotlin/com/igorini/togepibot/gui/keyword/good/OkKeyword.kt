package com.igorini.togepibot.gui.keyword.good

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "OK" */
object OkKeyword : Keyword() {
    override fun folder() = "good\\ok"
    override fun voiceRus() = listOf("окей", "ок")
    override fun voiceEng() = listOf("okay", "ok")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("ok")
}
