package com.igorini.togepibot.gui.keyword.guy

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Brunet" */
object BrunetKeyword : Keyword() {
    override fun folder() = "guy\\brunet"
    override fun voiceRus() = listOf("брюнет", "брюнета", "брюнету", "брюнетом", "брюнете", "брюнеты", "брюнетов", "брюнетам", "брюнетами", "брюнетах")
    override fun voiceEng() = listOf("brunet")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("brunet")
}
