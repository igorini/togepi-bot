package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Begging" */
object BeggingKeyword : Keyword() {
    override fun folder() = "begging"
    override fun voiceRus() = listOf("умоляюще", "умолять", "умолял", "умоляла", "умоляло", "умоляли", "умоляв", "умолявши", "умоляешь", "умоляет", "умоляем", "умоляете", "умоляют", "умоляй", "умоляйте", "умоляя", "умоляю", "помолимся", "молить", "молил", "молила", "молило", "молили", "молив", "моливши", "молишь", "молит", "молим", "молите", "молят", "моли", "молите", "моля", "молю")
    override fun voiceEng() = listOf("beg", "begging", "begs", "begged")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("blessrng")
}