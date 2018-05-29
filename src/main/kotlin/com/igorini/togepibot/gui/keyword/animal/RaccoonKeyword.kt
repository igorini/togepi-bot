package com.igorini.togepibot.gui.keyword.animal

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Raccoon" */
object RaccoonKeyword : Keyword() {
    override fun folder() = "animal\\raccoon"
    override fun voiceRus() = listOf("енот", "енота", "еноту", "енотом", "еноте", "еноты", "енотов", "енотах", "енотам", "енотик", "енотики", "енотика", "енотику", "енотиком", "енотиков", "енотикам", "енотиках")
    override fun voiceEng() = listOf("raccoon", "racoons")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("raccattack")
}
