package com.igorini.togepibot.gui.keyword.person.actor

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Keanu Reeves" */
object KeanuReevesKeyword : Keyword() {
    override fun folder() = "person\\actor\\keanu-reeves"
    override fun voiceRus() = listOf("киану", "кеану")
    override fun voiceEng() = listOf("keanu")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("keanu")
}
