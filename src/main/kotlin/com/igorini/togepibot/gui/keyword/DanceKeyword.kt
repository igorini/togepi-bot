package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Dance" */
object DanceKeyword : Keyword() {
    override fun folder() = "dance"
    override fun voiceRus() = listOf("танец", "танца", "танцу", "танцем", "танце", "танцевать", "танцую", "танцуешь", "танцует", "танцуем", "потанцуем", "танцуете", "танцуют", "танцевал", "танцевала", "танцевали", "танцуй", "танцуйте", "танцуя", "танцевав", "танцующий", "танцующего", "танцующему", "танцующим", "танцующем", "танцующая", "танцуещей", "танцующую", "танцующие", "танцующих", "танцующим", "танцующими", "пляска", "пляски", "пляске", "пляску", "пляской", "плясок", "пляскам", "плясками", "плясках", "пляши", "пляшите", "пляшу", "пляшешь", "пляшет", "пляшем", "пляшете", "пляшут", "плясал", "плясала", "плясало", "плясали", "пляшущий", "пляшущая", "пляшущие")
    override fun voiceEng() = listOf("dance", "dancing", "danced", "dances")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("jamespls")
}
