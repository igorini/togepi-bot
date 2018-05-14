package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Fat" */
object FatKeyword : Keyword() {
    override fun folder() = "fat"
    override fun voiceRus() = listOf("толстый", "толстого", "толстому", "толстого", "толстым", "толстом", "толстая", "толстую", "толстое", "толстые", "толстых", "толстыми", "толстел", "растолстел", "растолстела", "располнел", "располнела", "жирный", "жирдяй", "жирного", "жирному", "жирным", "жирном", "жирная", "жирной", "жирную", "жирное", "жирные", "жирных", "жирным", "жирными", "толстяк", "пухляш", "пухлый", "пухлого", "пухлому", "пухлым", "пухлом", "пухлая", "пухлой", "пухлую", "пухлые", "пухлых", "пухлым", "пухлых", "пухлыми", "толстушка", "толстуха", "жируха", "пышка", "брюховатый", "брюховатая")
    override fun voiceEng() = listOf("fat", "fatty", "chubby")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("fat")
}