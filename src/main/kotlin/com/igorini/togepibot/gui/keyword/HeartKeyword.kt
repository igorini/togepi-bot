package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Heart" */
object HeartKeyword : Keyword() {
    override fun folder() = "heart"
    override fun voiceRus() = listOf("сердце", "сердца", "сердцу", "сердцем", "сердца", "сердец", "сердцам", "сердцами", "сердцах", "сердечко", "сердечка", "сердечку", "сердечком", "сердечке", "сердечки", "сердечек", "сердечкам", "сердечками", "сердечках")
    override fun voiceEng() = listOf("heart", "hearts")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("bleedpurple", "twitchunity")
}
