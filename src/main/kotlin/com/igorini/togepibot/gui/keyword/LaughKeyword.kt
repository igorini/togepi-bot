package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Laugh" */
object LaughKeyword : Keyword() {
    override fun folder() = "laugh"
    override fun voiceRus() = listOf("шутник", "смешно", "весело", "забавно", "смешу", "смешишь", "смешит", "смешим", "смешите", "смешат", "смешил", "смешила", "смешили", "смеши", "смешите", "хаха", "ахаха", "ахахах", "ахахахаха", "хахаха", "ахах")
    override fun voiceEng() = listOf("laugh", "funny", "funnier", "funniest", "laughed", "laughing", "lol", "haha", "ahaha")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("lul")
}
