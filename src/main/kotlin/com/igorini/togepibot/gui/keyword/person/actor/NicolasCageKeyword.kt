package com.igorini.togepibot.gui.keyword.person.actor

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Nicolas Cage" */
object NicolasCageKeyword : Keyword() {
    override fun folder() = "person\\actor\\nicolas-cage"
    override fun voiceRus() = listOf("николас кейдж", "николаса кейджа", "николасу кейджу", "николасом кейджом")
    override fun voiceEng() = listOf("nicolas cage")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("nicolascage")
}
