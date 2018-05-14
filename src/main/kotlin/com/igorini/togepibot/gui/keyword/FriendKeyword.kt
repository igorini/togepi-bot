package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Friend" */
object FriendKeyword : Keyword() {
    override fun folder() = "friend"
    override fun voiceRus() = listOf("друг", "друга", "другу", "друге", "друзья", "друзей", "друзьям", "друзьями", "друзьях", "подруга", "подруги", "подруге", "подругу", "подругой", "подруг", "подругам", "подругами", "подругах", "дружба", "дружбы", "дружбе", "дружбу", "дружбой")
    override fun voiceEng() = listOf("friend")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("friend")
}