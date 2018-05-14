package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Angry" */
object AngryKeyword : Keyword() {
    override fun folder() = "angry"
    override fun voiceRus() = listOf("гореть", "горел", "горела", "горело", "горели", "горев", "горевши", "горишь", "горит", "горим", "горите", "горят", "гори", "горю", "подгораю", "злость", "злости", "злостью", "злиться", "злится", "злой", "злого", "злому", "злого", "злым", "злом", "злая", "злой", "злую", "злое", "злого", "злое", "злые", "злых", "злым", "злыми")
    override fun voiceEng() = listOf("angry", "mad", "furious")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("angry")
}
