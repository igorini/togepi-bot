package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "To Type" */
object ToTypeKeyword : Keyword() {
    override fun folder() = "to-type"
    override fun voiceRus() = listOf("печатать", "печатаю", "печатаешь", "печатает", "печатаем", "печатают", "печатал", "печатала", "печатали", "печатай", "печатайте")
    override fun voiceEng() = listOf("typing", "to type")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("totype")
}
