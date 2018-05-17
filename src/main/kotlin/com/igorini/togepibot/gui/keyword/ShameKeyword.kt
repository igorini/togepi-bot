package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Shame"/"Facepalm" */
object ShameKeyword : Keyword() {
    override fun folder() = "shame"
    override fun voiceRus() = listOf("стыд", "позор", "фейспалм", "рукалицо", "стыда", "стыду", "стыдом", "стыде", "позорно", "позора", "позору", "позором", "позоре", "позоров")
    override fun voiceEng() = listOf("shame", "facepalm", "ashamed")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("failfish")
}
