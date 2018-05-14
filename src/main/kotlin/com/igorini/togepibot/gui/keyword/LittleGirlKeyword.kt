package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Little Girl" */
object LittleGirlKeyword : Keyword() {
    override fun folder() = "little-girl"
    override fun voiceRus() = listOf("девочка", "девочки", "девочке", "девочку", "девочкой", "девочек", "девочкам", "девочками", "девочках")
    override fun voiceEng() = listOf("little girl")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("littlegirl")
}
