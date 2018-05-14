package com.igorini.togepibot.gui.keyword.weather

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Cold" */
object ColdKeyword : Keyword() {
    override fun folder() = "weather\\cold"
    override fun voiceRus() = listOf("холодно", "прохладно", "холода", "холоду", "холодом", "холода", "холодов", "холодам", "холодами", "холодах", "прохлада", "прохладе", "прохладу", "мороз", "мороза", "морозу", "морозом", "морозе", "морозы", "морозов", "морозам", "морозами", "морозах")
    override fun voiceEng() = listOf("cold", "freeze", "freezing")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("cold")
}
