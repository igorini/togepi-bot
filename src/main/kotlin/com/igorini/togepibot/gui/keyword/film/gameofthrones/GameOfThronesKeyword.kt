package com.igorini.togepibot.gui.keyword.film.gameofthrones

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Game of Thrones" */
object GameOfThronesKeyword : Keyword() {
    override fun folder() = "film\\game-of-thrones"
    override fun voiceRus() = listOf("игра престолов", "игре престолов", "игры престолов", "игру престолов", "игрой престолов", "игра тронов", "игры тронов", "игре тронов", "игру тронов", "ирой тронов", "плип", "песнь льда и пламени")
    override fun voiceEng() = listOf("game of thrones", "songs of ice and fire")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("gameofthrones")
}
