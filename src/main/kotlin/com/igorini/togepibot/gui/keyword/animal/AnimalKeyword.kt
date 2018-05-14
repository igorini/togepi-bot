package com.igorini.togepibot.gui.keyword.animal

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Animal" */
object AnimalKeyword : Keyword() {
    override fun folder() = "animal"
    override fun voiceRus() = listOf("животное", "жвиотного", "животному", "животном", "животные", "животных", "зверь", "зверя", "звери", "зверям", "зверю", "зверей")
    override fun voiceEng() = listOf("animal", "animals", "beast", "beasts")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("animal")
}