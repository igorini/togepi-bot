package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "To Eat" */
object ToEatKeyword : Keyword() {
    override fun folder() = "to-eat"
    override fun voiceRus() = listOf("поесть", "поел", "поела", "поем", "ел", "ем", "ела", "поели", "поешь", "поешьте", "поедим", "кушать", "жрать", "жру", "жрешь", "жрет", "жрем", "жрете", "жрут", "жрал", "жрала", "жрали", "жри", "жрите", "съел", "съела", "съели", "кушаю", "кушаешь", "кушает", "кушаем", "кушаете", "кушают", "кушал", "кушала", "кушали", "кушай", "кушайте")
    override fun voiceEng() = listOf("eat")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("eat")
}
