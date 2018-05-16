package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Obida" */
object ObidaKeyword : Keyword() {
    override fun folder() = "obida"
    override fun voiceRus() = listOf("обида", "обидно", "обижаться", "обидеться", "обиделся", "обиделась", "обижайся", "обиделись", "обижусь", "обидишься", "обидится", "обидимся", "обидитесь", "обидятся")
    override fun voiceEng() = listOf("obida")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("obida")
}
