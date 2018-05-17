package com.igorini.togepibot.gui.keyword

/** Represents a Sarcasm keyword */
object SarcasmKeyword : Keyword() {
    override fun folder() = "sarcasm"
    override fun voiceRus() = listOf("честно", "сарказм", "каппа", "капа")
    override fun voiceEng() = listOf("honestly", "kappa", "kappaclaus")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("kappa", "minik", "kappahd", "keepo")
}