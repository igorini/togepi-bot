package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Lazy" */
object LazyKeyword : Keyword() {
    override fun folder() = "lazy"
    override fun voiceRus() = listOf("лень", "безделье", "бездельник", "лентяй", "лентяйка", "ленюсь", "ленишься", "ленится", "лениться", "ленимся", "ленитесь", "ленятся", "ленился", "ленилась", "линилось", "ленились", "ленись", "ленитесь", "ленив", "ленива", "ленивый", "ленивого", "ленивому", "ленивого", "ленивым", "ленивом", "ленивая", "ленивой", "ленивою", "лениво", "ленивые", "ленивых")
    override fun voiceEng() = listOf("lazy")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("lazy")
}
