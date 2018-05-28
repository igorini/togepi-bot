package com.igorini.togepibot.gui.keyword.person.actor

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Eva Green" */
object EvaGreenKeyword : Keyword() {
    override fun folder() = "person\\actor\\eva-green"
    override fun voiceRus() = listOf("ева грин", "еву грин", "еве грин", "евой грин", "еви грин", "эва грин", "еву грин", "эве грин")
    override fun voiceEng() = listOf("eva green")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("evagreen")
}
