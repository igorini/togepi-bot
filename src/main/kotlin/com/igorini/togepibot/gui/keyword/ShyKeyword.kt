package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Shy" */
object ShyKeyword : Keyword() {
    override fun folder() = "shy"
    override fun voiceRus() = listOf("стесняться", "стесняюсь", "стесняться", "стеснялся", "стеснялась", "стесняешься", "стесняшка")
    override fun voiceEng() = listOf("shy", "shyness")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("shy")
}
