package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Blood" */
object BloodKeyword : Keyword() {
    override fun folder() = "blood"
    override fun voiceRus() = listOf("кровь", "крови", "кровью", "кровей", "кровям", "кровями", "кровях", "кровавый", "кровавого", "кровавому", "кровавым", "кровавом", "кровавая", "кровавой", "кровавую", "кровавое", "кровавым", "кровавые", "кровавыми", "кровавее", "кровав", "кроваво", "кровава", "кровавы")
    override fun voiceEng() = listOf("blood", "bloody", "bleed", "bleeding")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("blood")
}
