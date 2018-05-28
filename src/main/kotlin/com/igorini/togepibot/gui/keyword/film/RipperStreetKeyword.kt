package com.igorini.togepibot.gui.keyword.film

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Ripper Street" */
object RipperStreetKeyword : Keyword() {
    override fun folder() = "film\\ripper-street"
    override fun voiceRus() = listOf("улица потрошителя", "улицу потрошителя", "улице потрошителя")
    override fun voiceEng() = listOf("ripper street")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("ripperstreet")
}
