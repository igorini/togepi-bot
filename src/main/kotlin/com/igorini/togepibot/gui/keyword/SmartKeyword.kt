package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Smart" */
object SmartKeyword : Keyword() {
    override fun folder() = "smart"
    override fun voiceRus() = listOf("умно", "мудро", "смекалочка", "многоходовочка", "ум", "мудрость", "умный", "умного", "умному", "умного", "умным", "умном", "умная", "умной", "умную", "умное", "умные", "умных", "умным", "умными", "умнее", "умней", "умен", "умна", "мудрый", "мудрая", "мудрые")
    override fun voiceEng() = listOf("smart")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("smart")
}
