package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "To Smoke" */
object ToSmokeKeyword : Keyword() {
    override fun folder() = "to-smoke"
    override fun voiceRus() = listOf("курить", "курение", "курю", "куришь", "курит", "курим", "курите", "курят", "курил", "курила", "курили", "кури", "курите")
    override fun voiceEng() = listOf("smoke", "smoking", "smoked")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("smoke")
}
