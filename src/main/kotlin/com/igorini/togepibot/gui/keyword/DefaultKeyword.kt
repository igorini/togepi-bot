package com.igorini.togepibot.gui.keyword

import java.io.File

/** Represents */
object DefaultKeyword : Keyword() {
    override fun folder() = "default"
    override fun voiceAliases() = listOf("default")
}