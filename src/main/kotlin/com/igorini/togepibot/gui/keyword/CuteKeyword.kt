package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Cute" */
object CuteKeyword : Keyword() {
    override fun folder() = "cute"
    override fun voiceRus() = listOf("мило", "милый", "милого", "милому", "милым", "милом", "милая", "милой", "милую", "милейшая", "милейший", "мил", "мила", "милы", "няшно", "няшная", "няшный", "няшные", "няшность", "мимими", "мимимишность")
    override fun voiceEng() = listOf("cute")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("cute")
}