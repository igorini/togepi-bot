package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Hug" */
object HugKeyword : Keyword() {
    override fun folder() = "hug"
    override fun voiceRus() = listOf("обнимать", "обнимаю", "обнимаешь", "обнимает", "обнимаем", "обнимаете", "обнимают", "обнимал", "обнимала", "обнимало", "обнимали", "обнимай", "обнимайте", "обнимая", "обнимашки", "обнять", "обними", "обниму", "обнимешь", "объятие", "объятия")
    override fun voiceEng() = listOf("hug", "hugs", "hugged", "hugging")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("hug")
}
