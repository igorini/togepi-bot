package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Money" */
object MoneyKeyword : Keyword() {
    override fun folder() = "money"
    override fun voiceRus() = listOf("деньги", "денег", "деньгам", "деньгами", "деньгах", "богач", "богатей", "богатый", "богатого", "богатому", "богатым", "богатом", "богатая", "богатой", "богатую", "богатое", "богатые", "богатых", "богатым", "богатыми", "рубли", "рубль", "доллар", "доллары", "долларов", "рублей", "рублях")
    override fun voiceEng() = listOf("money", "dollars", "dollar", "rich")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("money")
}