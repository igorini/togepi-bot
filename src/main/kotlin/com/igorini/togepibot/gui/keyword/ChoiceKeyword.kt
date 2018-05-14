package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Choice" */
object ChoiceKeyword : Keyword() {
    override fun folder() = "choice"
    override fun voiceRus() = listOf("выбор", "выбора", "выбору", "выбором", "выборе", "выбрать", "выбрал", "выбрала", "выбрало", "выбрав", "выбравши", "выберешь", "веберет", "выберем", "выберете", "выберут", "выбери", "выберите", "выберу", "выбирать", "выбирал", "выбирала", "выбирало", "выбирали", "выбирав", "выбиравши", "выбираешь", "выбирает", "выбираем", "выбираете", "выбирают", "выбирай", "выбирайте", "выбирая", "выбираю")
    override fun voiceEng() = listOf("choice", "choose", "chose", "chosen", "choosing", "choices")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("choice")
}
