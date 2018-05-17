package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Wait" */
object WaitKeyword : Keyword() {
    override fun folder() = "wait"
    override fun voiceRus() = listOf("ждать", "ожидание", "подождать", "ожидать", "жду", "ждешь", "ждет", "ждем", "ждете", "ждут", "ждал", "ждала", "ждали", "жди", "ждите", "погоди", "погодите")
    override fun voiceEng() = listOf("wait", "waiting", "waits", "waited")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("wait")
}
