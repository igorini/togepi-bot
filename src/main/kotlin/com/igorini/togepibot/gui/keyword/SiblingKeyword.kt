package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Sibling" */
object SiblingKeyword : Keyword() {
    override fun folder() = "sibling"
    override fun voiceRus() = listOf("брат", "сестра", "брата", "брату", "братом", "брате", "братья", "братьев", "братьям", "братьям", "братьями", "сестры", "сестре", "сестру", "сестрой", "сестер", "сестрам", "сестрами", "сестрах")
    override fun voiceEng() = listOf("sibling", "siblings", "brother", "sister", "brothers", "sisters")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("brother")
}
