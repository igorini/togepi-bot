package com.igorini.togepibot.gui.keyword.girl

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Blonde Girl" */
object GirlBlondeHairKeyword : Keyword() {
    override fun folder() = "girl\\girl-blonde-hair"
    override fun voiceRus() = listOf("блондинка", "блондиночка", "блондинки", "блондинке", "блондинку", "блондинкой", "блондинок", "блондинкам", "блондинками", "блондинках")
    override fun voiceEng() = listOf("blonde girl")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("girlblonde")
}
