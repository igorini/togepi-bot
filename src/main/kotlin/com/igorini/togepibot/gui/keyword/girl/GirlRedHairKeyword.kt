package com.igorini.togepibot.gui.keyword.girl

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Red Hair Girl" */
object GirlRedHairKeyword : Keyword() {
    override fun folder() = "girl\\girl-red-hair"
    override fun voiceRus() = listOf("рыжая", "рыжей", "рыжую", "рыжуля", "рыжуле", "рыжулю", "рыжые девушки")
    override fun voiceEng() = listOf("red hair girl")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("girlredhair")
}
