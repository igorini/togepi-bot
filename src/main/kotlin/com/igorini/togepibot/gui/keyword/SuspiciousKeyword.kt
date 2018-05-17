package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Suspicious" */
object SuspiciousKeyword : Keyword() {
    override fun folder() = "suspicious"
    override fun voiceRus() = listOf("подозрительно", "подозрение", "подозрительный", "подозрительного", "подозрительному", "подозрительным", "подозрительном", "подозрительная", "подозрительной", "подозрительную", "подозрительное", "подозрительные", "подозрительных", "подозрительным", "подозрительными", "подозрителен", "подозрительна")
    override fun voiceEng() = listOf("suspicious")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("cmonbruh")
}
