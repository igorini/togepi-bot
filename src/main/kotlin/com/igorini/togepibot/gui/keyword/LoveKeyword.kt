package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Love" */
object LoveKeyword : Keyword() {
    override fun folder() = "love"
    override fun voiceRus() = listOf("любовь", "любить", "люблю", "любишь", "любит", "любим", "любите", "любят", "любил", "любила", "любило", "любили", "люби", "любя", "любив", "любимый", "любимого", "любимому", "любимым", "любимом", "любимая", "любимой", "любимую", "любимое", "любимые", "любимых", "любимым", "любимыми")
    override fun voiceEng() = listOf("love", "loves", "loved", "loving", "adore")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("love")
}