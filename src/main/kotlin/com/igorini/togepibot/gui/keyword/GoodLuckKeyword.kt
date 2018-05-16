package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Good Luck" */
object GoodLuckKeyword : Keyword() {
    override fun folder() = "good-luck"
    override fun voiceRus() = listOf("удачи", "удача", "удаче", "удачу", "удачей")
    override fun voiceEng() = listOf("good luck")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("goodluck")
}
