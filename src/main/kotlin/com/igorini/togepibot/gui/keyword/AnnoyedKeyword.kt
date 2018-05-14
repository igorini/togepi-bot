package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Annoyed" */
object AnnoyedKeyword : Keyword() {
    override fun folder() = "annoyed"
    override fun voiceRus() = listOf("раздражать", "раздражал", "раздражала", "раздражало", "раздражали", "раздражав", "раздражавши", "раздражаешь", "раздражает", "раздражаем", "раздражаете", "раздражают", "раздражай", "раздражая", "раздражаю", "раздражаться", "раздражающе", "раздраженный", "раздраженная", "раздражающий", "раздражающая", "раздраженно", "раздраженность")
    override fun voiceEng() = listOf("annoyed", "annoy", "annoying", "annoys")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("annoyed")
}
