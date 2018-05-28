package com.igorini.togepibot.gui.keyword.film

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Dikiy Angel" */
object DikiyAngelKeyword : Keyword() {
    override fun folder() = "film\\dikiy-angel"
    override fun voiceRus() = listOf("дикий ангел", "дикого ангела", "дикому ангелу", "диком ангеле")
    override fun voiceEng() = listOf("dikiy angel")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("dikiyangel")
}
