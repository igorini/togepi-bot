package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Wake Up" */
object WakeUpKeyword : Keyword() {
    override fun folder() = "wake-up"
    override fun voiceRus() = listOf("просыпаться", "проснись", "проснулся", "проснулась", "проснулось", "проснулись", "проснусь", "проснешься", "проснется", "проснемся", "проснетесь", "проснитесь")
    override fun voiceEng() = listOf("wake up", "woke up", "waking up")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("wakeup")
}