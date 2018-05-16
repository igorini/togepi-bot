package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Gift" */
object GiftKeyword : Keyword() {
    override fun folder() = "gift"
    override fun voiceRus() = listOf("подарок", "подарка", "подарку", "подарком", "подарке", "подарки", "подарков", "подарками", "подаркам", "подарках")
    override fun voiceEng() = listOf("gift", "gifts", "gifted", "gifting", "present", "presents")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("gift")
}
