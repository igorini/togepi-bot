package com.igorini.togepibot.gui.keyword.film

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Friends" */
object FriendsKeyword : Keyword() {
    override fun folder() = "film\\friends"
    override fun voiceRus() = listOf("друзья сериал", "сериал друзья")
    override fun voiceEng() = listOf("friends tv")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("friendstv")
}
