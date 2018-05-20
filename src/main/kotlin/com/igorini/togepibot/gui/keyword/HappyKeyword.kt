package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Happy" */
object HappyKeyword : Keyword() {
    override fun folder() = "happy"
    override fun voiceRus() = listOf("красота", "счастье", "счастья", "счастью", "счастьем", "счастливый", "счастливого", "счастливому", "счастливым", "счастливом", "счастливая", "счастливой", "счастливую", "счастливое", "счастливые", "счастливых", "счастливым", "счастливыми", "счастлив", "счастлива", "счастливы", "радость", "радости", "радостью", "радостный", "радостного", "радостному", "радостным", "радостном", "радостная", "радостной", "радостную", "радостное", "радостные", "радостных", "радостным", "радостными", "рад", "рада", "рады", "доволен", "довольна", "довольны", "доволный", "довольная")
    override fun voiceEng() = listOf("happy", "glad", "happier", "happiest")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("kreygasm", "vohiyo", "carlsmile", "feelsamazingman")
}
