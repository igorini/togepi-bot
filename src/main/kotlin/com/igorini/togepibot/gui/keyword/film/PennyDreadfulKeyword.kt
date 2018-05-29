package com.igorini.togepibot.gui.keyword.film

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Penny Dreadful" */
object PennyDreadfulKeyword : Keyword() {
    override fun folder() = "film\\penny-dreadful"
    override fun voiceRus() = listOf("бульварные ужасы", "страшные сказки", "грошовые ужасы", "ужасы по дешевке")
    override fun voiceEng() = listOf("penny dreadful")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("pennydreadful")
}
