package com.igorini.togepibot.gui.keyword.music

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Drums" */
object DrumsKeyword : Keyword() {
    override fun folder() = "music\\drums"
    override fun voiceRus() = listOf("барабан", "барабаны", "барабана", "барабаном", "барабане", "барабанов", "барабанам", "барабанами", "барабанах", "ударные", "ударник", "ударники")
    override fun voiceEng() = listOf("drums", "drum", "drumming")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("drums")
}