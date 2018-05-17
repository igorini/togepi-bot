package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Wink" */
object WinkKeyword : Keyword() {
    override fun folder() = "wink"
    override fun voiceRus() = listOf("подмигиваю", "подмигивание", "подмигиваешь", "подмигивал", "подмигивала")
    override fun voiceEng() = listOf("wink")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("tehepelo")
}
