package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Sweat" */
object SweatKeyword : Keyword() {
    override fun folder() = "sweat"
    override fun voiceRus() = listOf("пот", "потный", "вспотел", "вспотела", "потного", "потному", "потного", "потному", "потным", "потном", "потная", "потной", "потную", "потное", "потные", "потных", "потным", "потными", "потеть", "потею", "потеешь", "потеет", "потеем", "потеете", "потеют", "потел", "потела", "потело", "потели", "потей", "потейте", "стараться", "постараться", "стараюсь", "постараюсь", "стараешься", "постараешься", "старается", "постарается", "стараемся", "постараемся", "стараетесь", "постараетесь", "стараются", "постараются", "старался", "постарался", "старались", "постарались", "старайся", "постарайся", "старайтесь", "постарайтесь")
    override fun voiceEng() = listOf("sweat", "sweaty", "sweating")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("sweat")
}
