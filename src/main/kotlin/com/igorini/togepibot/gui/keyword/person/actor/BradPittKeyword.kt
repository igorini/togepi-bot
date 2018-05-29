package com.igorini.togepibot.gui.keyword.person.actor

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Brad Pitt" */
object BradPittKeyword : Keyword() {
    override fun folder() = "person\\actor\\brad-pitt"
    override fun voiceRus() = listOf("брэд питт", "брэд пит", "брэда питта", "брэду питту", "брэде питте")
    override fun voiceEng() = listOf("brad pitt")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("bradpitt")
}
