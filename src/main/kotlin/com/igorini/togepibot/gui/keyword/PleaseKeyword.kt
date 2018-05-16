package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Please" */
object PleaseKeyword : Keyword() {
    override fun folder() = "please"
    override fun voiceRus() = listOf("пожалуйста", "будь добр", "будь добра", "плиз", "плз", "пжл", "прошу", "просьба", "просишь", "просит", "просим", "просите", "просят", "просил", "просила", "просило", "просили", "проси", "попрошу", "попроси", "просите", "попросишь")
    override fun voiceEng() = listOf("please")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("please")
}
