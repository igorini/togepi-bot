package com.igorini.togepibot.gui.keyword.weather

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Weather" */
object WeatherKeyword : Keyword() {
    override fun folder() = "weather"
    override fun voiceRus() = listOf("погода", "погожий", "погожая", "погоды", "погоде", "погоду", "погодой", "погод", "погодка", "погодки", "погодке", "погодку", "погодкой")
    override fun voiceEng() = listOf("weather")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("weather")
}
