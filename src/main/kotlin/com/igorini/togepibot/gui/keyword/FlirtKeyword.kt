package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Flirt" */
object FlirtKeyword : Keyword() {
    override fun folder() = "flirt"
    override fun voiceRus() = listOf("детка", "кроха", "крошка", "бейба", "зайчик", "зайка", "флирт", "флирта", "флирту", "флиртовать", "флиртую", "флиртуешь", "флиртует", "флиртуем", "флиртуете", "флиртуют", "флиртовал", "флиртовала", "флиртовали", "флиртуй", "флиртуйте", "флиртуя", "заигрывать", "заигрываю", "заигрываешь", "заигрывает", "заигрываем", "заигрываете", "заигрывают", "заигрывал", "заигрывала", "заигрывали", "заигрывай", "заигрывайте", "заигрывая")
    override fun voiceEng() = listOf("flirt", "flirts", "flirting")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("flirt")
}
