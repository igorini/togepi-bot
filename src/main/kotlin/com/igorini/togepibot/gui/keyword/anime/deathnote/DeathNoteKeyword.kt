package com.igorini.togepibot.gui.keyword.anime.deathnote

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Death Note" */
object DeathNoteKeyword : Keyword() {
    override fun folder() = "anime\\death-note"
    override fun voiceRus() = listOf("тетрадь смерти", "тетрадка смерти", "тетради смерти", "тетраде смерти")
    override fun voiceEng() = listOf("death note")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("deathnote")
}