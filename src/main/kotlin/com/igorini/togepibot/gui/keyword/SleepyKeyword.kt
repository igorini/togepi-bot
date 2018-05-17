package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Sleepy" */
object SleepyKeyword : Keyword() {
    override fun folder() = "sleepy"
    override fun voiceRus() = listOf("сон", "сонный", "спокойной ночи", "споки", "сна", "сну", "сном", "сне"," сны", "снов", "снам", "снами", "снах", "сонного", "сонному", "сонным", "сонном", "сонная", "сонной", "сонную", "сонное", "сонные", "сонных", "сонным", "сонными", "сонно")
    override fun voiceEng() = listOf("sleepy", "sleep", "good night")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("sleepy")
}
