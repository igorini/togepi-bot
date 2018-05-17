package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Sad" */
object SadKeyword : Keyword() {
    override fun folder() = "sad"
    override fun voiceRus() = listOf("печаль", "печально", "печалька", "грустно", "жаль", "расстроен", "разочарован", "печали", "печален", "грустный", "грустная", "грустную", "печалиться", "грустного", "грустному", "грустным", "грустном", "грустной", "грустную", "грустное", "печальный", "печальная", "грустные", "грустных", "грустными", "грустна", "тоска", "тоскливо", "тоскливая", "тоскливый")
    override fun voiceEng() = listOf("sad", "dissapointed")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("notlikethis", "feelsbadman")
}
