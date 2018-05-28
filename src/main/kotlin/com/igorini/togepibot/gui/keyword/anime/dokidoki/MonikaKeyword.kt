package com.igorini.togepibot.gui.keyword.anime.dokidoki

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Monika" */
object MonikaKeyword : Keyword() {
    override fun folder() = "anime\\doki-doki\\monika"
    override fun voiceRus() = listOf("моника", "монику", "моники", "моникой", "монике")
    override fun voiceEng() = listOf("monika")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("monika")
}