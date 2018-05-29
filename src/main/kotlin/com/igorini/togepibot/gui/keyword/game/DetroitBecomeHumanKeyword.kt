package com.igorini.togepibot.gui.keyword.game

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Detroit: Become Human" */
object DetroitBecomeHumanKeyword : Keyword() {
    override fun folder() = "game\\detroit-become-human"
    override fun voiceRus() = listOf("детройт стать человеком")
    override fun voiceEng() = listOf("detroit become human")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("detroitbecomehuman")
}