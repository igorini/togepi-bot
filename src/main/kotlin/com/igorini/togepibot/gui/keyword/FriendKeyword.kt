package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Friend" */
object FriendKeyword : Keyword() {
    override fun folder() = "friend"
    override fun voiceRus() = listOf("друг", "друга", "другу", "друге", "друзья", "друзей", "друзьям", "друзьями", "друзьях", "подруга", "подруги", "подруге", "подругу", "подругой", "подруг", "подругам", "подругами", "подругах", "дружба", "дружбы", "дружбе", "дружбу", "дружбой", "дружу", "дружишь", "дружит", "дружим", "дружите", "дружат", "дружил", "дружила", "дружили", "прятель", "приятеля", "приятелю", "приятелем", "приятеле", "приятели", "приятелей", "приятелям", "приятелями", "приятелях", "подружка", "подружку", "подружке", "подружки", "дружить", "дружок", "дружка", "дружки", "дружке", "кореш", "корешу", "дружбан", "дружбану")
    override fun voiceEng() = listOf("friend", "friends", "friendship")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("friend")
}