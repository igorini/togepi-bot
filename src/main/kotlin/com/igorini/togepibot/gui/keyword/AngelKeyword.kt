package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Angel" */
object AngelKeyword : Keyword() {
    override fun folder() = "angel"
    override fun voiceRus() = listOf("ангельский", "ангельская", "ангел", "ангела", "ангелу", "ангелом", "ангеле", "ангелы", "ангелов", "ангелам", "ангелами", "ангелах", "ангелок", "ангелку", "ангелку", "ангелка", "ангелком", "ангелке", "ангелочек", "святой", "святая", "святого", "святую")
    override fun voiceEng() = listOf("angel", "angels")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("angel")
}
