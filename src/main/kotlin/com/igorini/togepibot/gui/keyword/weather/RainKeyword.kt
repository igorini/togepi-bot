package com.igorini.togepibot.gui.keyword.weather

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Rain" */
object RainKeyword : Keyword() {
    override fun folder() = "weather\\rain"
    override fun voiceRus() = listOf("дождь", "дождя", "дождю", "дождем", "дождей", "дождям", "дождями", "дождях", "дождливо", "дождливый", "дождливая", "дождик", "дождика", "дождику", "дождиком", "дождике", "дождики", "дождиков", "дождикам", "жождиками", "дождиках", "ливень", "ливня", "ливню", "ливнем", "ливне", "ливней", "ливням", "ливнями", "ливнях", "моросит", "морось", "изморось", "непогода", "непогожий", "непогожая", "непогоды", "непогоде", "непогоде", "непогоду", "непогодой")
    override fun voiceEng() = listOf("rain", "rains", "rained", "raining")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("rain")
}
