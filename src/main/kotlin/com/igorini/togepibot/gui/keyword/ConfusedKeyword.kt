package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Confused" */
object ConfusedKeyword : Keyword() {
    override fun folder() = "confused"
    override fun voiceRus() = listOf("не понял", "не понятно", "непонятно", "не могу понять", "не пойму", "не поймешь", "не поймет", "не поймем", "не ясно", "не поймете", "не поймут", "не поняла", "не поняли", "что здесь происходит", "не понимаю", "не понимаешь", "не понимает", "не понимаем", "не понимате", "не понимают", "не понимал", "не понимала", "не понимали", "не понимало")
    override fun voiceEng() = listOf("wtf", "puzzled", "confused", "confuse", "confusing", "uncertain")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("wtf")
}
