package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Pain" */
object PainKeyword : Keyword() {
    override fun folder() = "pain"
    override fun voiceRus() = listOf("боль", "больно")
    override fun voiceEng() = listOf("pain", "painful", "hurt", "hurts", "hurting")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("pain")
}
