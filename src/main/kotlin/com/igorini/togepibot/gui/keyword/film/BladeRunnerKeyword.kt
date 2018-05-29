package com.igorini.togepibot.gui.keyword.film

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Blade Runner" */
object BladeRunnerKeyword : Keyword() {
    override fun folder() = "film\\blade-runner"
    override fun voiceRus() = listOf("бегущий по лезвию", "бегущего по лезвию")
    override fun voiceEng() = listOf("blade runner")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("bladerunner")
}
