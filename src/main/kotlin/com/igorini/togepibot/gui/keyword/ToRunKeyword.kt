package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Run" */
object ToRunKeyword : Keyword() {
    override fun folder() = "to-run"
    override fun voiceRus() = listOf("бег", "бежать", "бежишь", "бежит", "бежим", "бежите", "бегут", "бежал", "бежала", "бежали", "беги", "бежим", "бегите")
    override fun voiceEng() = listOf("run", "ran", "running")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("run")
}
