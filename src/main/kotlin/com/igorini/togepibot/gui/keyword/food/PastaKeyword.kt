package com.igorini.togepibot.gui.keyword.food

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Pasta" */
object PastaKeyword : Keyword() {
    override fun folder() = "food\\pasta"
    override fun voiceRus() = listOf("макароны", "макарошки", "макаронами", "макарончики", "макаронах", "макаронам", "макарон")
    override fun voiceEng() = listOf("pasta")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("pasta")
}
