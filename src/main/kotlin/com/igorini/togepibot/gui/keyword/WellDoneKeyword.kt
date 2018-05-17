package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Well Done" */
object WellDoneKeyword : Keyword() {
    override fun folder() = "well-done"
    override fun voiceRus() = listOf("молодец", "умница", "умничка", "хорош", "хороша", "поздравляю", "поздравляем", "поздравил", "поздравила", "грац", "гратс")
    override fun voiceEng() = listOf("well done", "congratulations")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("partypopper", "bloodtrail", "seemsgood", "hswp", "clap")
}