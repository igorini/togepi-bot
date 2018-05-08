package com.igorini.togepibot.gui.keyword

/** Represents a Hello keyword */
object HelloKeyword : Keyword() {
    override fun folder() = "hello"
    override fun voiceRus() = listOf("привет", "приветики", "здравствуй", "здарова", "приветсвую", "приветик", "здравствуйте", "добрый день", "доброе утро", "добрый вечер", "даров", "салют")
    override fun voiceEng() = listOf("hello", "hi", "greetings", "hey", "hiya")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("heyguys", "koncha")
}