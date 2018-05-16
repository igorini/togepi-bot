package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Read"/"Book" */
object ReadKeyword : Keyword() {
    override fun folder() = "read"
    override fun voiceRus() = listOf("читать", "книга", "читаю", "читаешь", "читает", "читаем", "читаете", "читают", "читал", "читала", "читали", "читай", "читайте", "читая", "начитан", "начитана", "книги", "книге", "книгу", "книгой", "книг", "книгам", "книгами", "книгах")
    override fun voiceEng() = listOf("read", "reads", "reading", "book", "books")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("book")
}
