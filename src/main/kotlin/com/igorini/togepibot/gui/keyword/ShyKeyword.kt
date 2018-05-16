package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Yes" */
object ShyKeyword : Keyword() {
    override fun folder() = "aga"
    override fun voiceRus() = listOf("стесняться", "стесняюсь", "стесняться", "стеснялся", "стеснялась", "стесняешься")
    override fun voiceEng() = listOf("yes")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("yes")
}
