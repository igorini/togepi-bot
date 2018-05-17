package com.igorini.togepibot.gui.keyword.animal

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Dog" */
object DogKeyword : Keyword() {
    override fun folder() = "animal\\dog"
    override fun voiceRus() = listOf("пес", "пса", "псы", "псу", "псе", "собака", "собаки", "собаку", "собаке", "собак", "собачка", "собачки", "щенок", "щенки", "щенка")
    override fun voiceEng() = listOf("dogs", "dog", "doggy")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("frankerz", "ralpherz", "corgiderp", "ohmydog", "concerndoge")
}