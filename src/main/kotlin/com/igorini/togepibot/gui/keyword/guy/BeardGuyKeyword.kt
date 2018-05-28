package com.igorini.togepibot.gui.keyword.guy

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Beard Guy" */
object BeardGuyKeyword : Keyword() {
    override fun folder() = "guy\\beard"
    override fun voiceRus() = listOf("бородач", "бородача", "бородаче", "бородачу", "бородачи", "бородачей", "бородачах")
    override fun voiceEng() = listOf("beard")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("beard")
}
