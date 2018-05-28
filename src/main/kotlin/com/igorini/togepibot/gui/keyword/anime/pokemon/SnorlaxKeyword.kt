package com.igorini.togepibot.gui.keyword.anime.pokemon

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Snorlax" */
object SnorlaxKeyword : Keyword() {
    override fun folder() = "anime\\pokemon\\snorlax"
    override fun voiceRus() = listOf("снорлакс", "снорлакса", "снорлаксе", "снорлаксу", "снорлаксы", "снорлаксов", "снорлаксах", "снорлаксам", "снорлаксами")
    override fun voiceEng() = listOf("snorlax")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("opprtnsnorlax")
}