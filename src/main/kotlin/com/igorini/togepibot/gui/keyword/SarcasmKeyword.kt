package com.igorini.togepibot.gui.keyword

import java.io.File

/** Represents */
object SarcasmKeyword : Keyword() {
    override fun folder() = "sarcasm"
    override fun voiceAliases() = listOf("честно")
}