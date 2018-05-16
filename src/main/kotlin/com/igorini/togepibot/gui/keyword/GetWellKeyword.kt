package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Get Well" */
object GetWellKeyword : Keyword() {
    override fun folder() = "get-well"
    override fun voiceRus() = listOf("выздоравливай", "поправляйся", "не болей", "здоровья", "будь здоров", "выздоравливайте", "поправляйтесь", "заболел", "болею", "заболела", "больница", "больнице", "больницу", "больничный", "больничном", "простудился", "простудилась")
    override fun voiceEng() = listOf("get well", "hospital")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("getwell")
}
