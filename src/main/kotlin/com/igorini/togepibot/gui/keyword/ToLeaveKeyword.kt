package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "To Leave" */
object ToLeaveKeyword : Keyword() {
    override fun folder() = "to-leave"
    override fun voiceRus() = listOf("пойти", "уйти", "покидать", "пошел", "пошла", "пошли", "пойду", "пойдешь", "пойдет", "пойдем", "пойдете", "пойдут", "пойди", "пшел", "уходить", "ухожу", "уходишь", "ушел", "ушла", "ушли", "уйду", "уйдешь", "уйдет", "уйдем", "уйдете", "уйдут", "уйди", "покину", "покидаю")
    override fun voiceEng() = listOf("leave", "leaving")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("leave")
}
