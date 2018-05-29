package com.igorini.togepibot.gui.keyword.anime

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Howl's Moving Castle" */
object HowlsMovingCastleKeyword : Keyword() {
    override fun folder() = "anime\\howls-moving-castle"
    override fun voiceRus() = listOf("ходячий замок", "ходячего замка", "ходячему замку", "ходячем замке")
    override fun voiceEng() = listOf("moving castle")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("howlsmovingcastle")
}
