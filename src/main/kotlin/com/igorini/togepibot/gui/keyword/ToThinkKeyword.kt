package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "To Think" */
object ToThinkKeyword : Keyword() {
    override fun folder() = "to-think"
    override fun voiceRus() = listOf("думать", "думаю", "думаешь", "думает", "думаем", "думаете", "думают", "думал", "думала", "думали", "думай", "дуймайте", "подумаю", "подумай", "подумаем", "подумать")
    override fun voiceEng() = listOf("think", "thinks", "thinking")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("think")
}