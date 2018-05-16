package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Nervous" */
object NervousKeyword : Keyword() {
    override fun folder() = "nervous"
    override fun voiceRus() = listOf("нервничать", "переживать", "нервничал", "нервничаю", "переживаю", "переживал", "нервничала", "переживала", "неловко")
    override fun voiceEng() = listOf("yes")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("yes")
}
