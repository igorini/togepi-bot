package com.igorini.togepibot.gui.keyword.anime.pokemon

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Pikachu" */
object PikachuKeyword : Keyword() {
    override fun folder() = "anime\\pokemon\\pikachu"
    override fun voiceRus() = listOf("пикачу", "пикачума")
    override fun voiceEng() = listOf("pikachu")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("pokpikachu")
}