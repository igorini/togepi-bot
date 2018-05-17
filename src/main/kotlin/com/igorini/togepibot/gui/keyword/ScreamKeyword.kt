package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Scream" */
object ScreamKeyword : Keyword() {
    override fun folder() = "scream"
    override fun voiceRus() = listOf("крик", "кричать", "орать", "накричать", "наорать", "ор", "накричала", "накричал", "наорал", "наорала", "кричу", "кричишь", "кричит", "кричим", "кричите", "кричат", "кричал", "кричала", "кричало", "кричали", "кричи", "кричите", "крича", "ору", "орешь", "орет", "орем", "орете", "орут", "орал", "орала", "орало", "орали", "ори", "орите")
    override fun voiceEng() = listOf("scream", "screams", "screaming", "screamed")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("swiftrage")
}
