package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Phone" */
object PhoneKeyword : Keyword() {
    override fun folder() = "phone"
    override fun voiceRus() = listOf("тлф", "телефон", "смартфон", "айфон", "сотовый", "мобильный", "мобильник", "телефона", "телефону", "телефоном", "телефоне", "телефоны", "телефонов", "телефонам", "телефонами", "телефонах")
    override fun voiceEng() = listOf("phone", "telephone", "phones")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("phone")
}
