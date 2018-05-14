package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Crazy" */
object CrazyKeyword : Keyword() {
    override fun folder() = "crazy"
    override fun voiceRus() = listOf("безумие", "безумия", "безумию", "безумием", "безумии", "безумный", "безумного", "безумному", "безумного", "безумным", "безумном", "безумная", "безумной", "безумную", "безумен", "безумна", "безумны", "безумец", "сумасшедший", "сумасшедшего", "сумасшедшему", "сумасшедшим", "сумасшедшем", "сумасшедшая", "сумасшедшей", "сумасшедшую")
    override fun voiceEng() = listOf("crazy", "crazier", "craziest", "madness")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("crazy")
}
