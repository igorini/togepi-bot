package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Kiss" */
object KissKeyword : Keyword() {
    override fun folder() = "kiss"
    override fun voiceRus() = listOf("целовать", "целую", "целуешь", "целует", "целуем", "целуете", "целуют", "целовал", "целовала", "целовали", "целуй", "поцелую", "целуйте", "поцелуй", "поцелую", "расцелую", "поцеловал", "поцеловала", "поцеловать", "чмок", "чмоки")
    override fun voiceEng() = listOf("kiss", "kisses", "kissed", "kissing")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("kiss")
}
