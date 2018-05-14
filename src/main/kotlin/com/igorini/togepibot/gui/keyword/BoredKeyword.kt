package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Bored" */
object BoredKeyword : Keyword() {
    override fun folder() = "bored"
    override fun voiceRus() = listOf("скучный", "скучного", "скучному", "скучного", "скучным", "скучном", "скучная", "скучной", "скучную", "скучное", "скучные", "скучных", "скучным", "скучными", "скучнее", "скучней", "скучен", "скучна", "скучны", "сколько это может продолжаться")
    override fun voiceEng() = listOf("bored", "boring", "boredom", "how long can this go on")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("residentsleeper")
}