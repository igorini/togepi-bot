package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Sneak" */
object SneakKeyword : Keyword() {
    override fun folder() = "sneak"
    override fun voiceRus() = listOf("красться", "крадусь", "крадешься", "крадется", "крадемся", "крадетесь", "крадутся", "крался", "кралась", "крались", "крадущийся", "крадущегося", "крадущемуся", "крадущегося", "крадущимся", "крадущемся", "крадущаяся", "крадущейся", "крадущуюся", "крадущейся", "подкрался", "подкралась", "подкрадываюсь")
    override fun voiceEng() = listOf("sneak", "stealth", "sneaking")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("sneak")
}
