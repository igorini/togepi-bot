package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Victory" */
object VictoryKeyword : Keyword() {
    override fun folder() = "victory"
    override fun voiceRus() = listOf("победа", "победы", "победить", "выиграть", "побеждать", "выигрывать", "выигрыш", "выиграл", "выиграла", "выиграли", "выиграю", "выиграешь", "выиграют", "выиграй", "победе", "победу", "победой", "побед", "победам", "победами", "победах", "победил", "победила", "победили", "побежу", "победишь", "победит", "победим", "победите", "победят", "победи", "победите")
    override fun voiceEng() = listOf("victory", "wins", "wins", "won", "winning")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("win")
}
