package com.igorini.togepibot.gui.keyword.cook

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Cook" */
object CookKeyword : Keyword() {
    override fun folder() = "cook"
    override fun voiceRus() = listOf("готовить еду", "готовил еду", "готовила еду", "готовило еду", "готовили еду", "готовив еду", "готовивши еду", "готовишь еду", "готовит еду", "готовим еду", "готовите еду", "готовят еду", "готовьте еду", "готовя еду", "готовлю еду", "стяпать", "стряпал", "стряпала", "стряпало", "стряпали", "стряпав", "стяпавши", "стряпаешь", "стряпает", "стряпаем", "стряпаете", "стряпают", "стряпай", "стряпайте", "стряпая", "стряпаю", "кухня", "кухни", "кухне", "кухней")
    override fun voiceEng() = listOf("cook", "cooking")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("cook")
}
