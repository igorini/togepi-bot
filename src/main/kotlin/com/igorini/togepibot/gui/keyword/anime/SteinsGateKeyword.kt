package com.igorini.togepibot.gui.keyword.anime

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Steins Gate" */
object SteinsGateKeyword : Keyword() {
    override fun folder() = "anime\\steins-gate"
    override fun voiceRus() = listOf("врата штейна", "врата штайнера", "штейнгейт", "тутуру")
    override fun voiceEng() = listOf("stein's gate", "steins gate", "steins", "tuturu")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("steins-gate")
}
