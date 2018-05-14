package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Fight" */
object FightKeyword : Keyword() {
    override fun folder() = "fight"
    override fun voiceRus() = listOf("драка", "дуэль", "дуэлька", "дуэли", "дуэлью", "дуэльку", "дуэльки", "дуэлиться", "дуэлюсь", "драка", "схватка")
    override fun voiceEng() = listOf("fight", "duel")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("fight")
}
