package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Saliva" */
object SalivaKeyword : Keyword() {
    override fun folder() = "saliva"
    override fun voiceRus() = listOf("слюна", "слюнка", "слюны", "слюне", "слюну", "слюной", "слюнки", "слюнке", "слюнку", "слюнкой")
    override fun voiceEng() = listOf("saliva")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("saliva")
}