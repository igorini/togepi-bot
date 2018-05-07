package com.igorini.togepibot.gui.keyword

import java.io.File

/** Represents */
object HelloKeyword : Keyword() {
    override fun folder() = "hello"
    override fun voiceAliases() = listOf("привет", "здравствуй", "приветики", "здарова", "приветсвую", "приветик", "здравствуйте")
}