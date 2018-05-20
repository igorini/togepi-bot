package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Cry" */
object CryKeyword : Keyword() {
    override fun folder() = "cry"
    override fun voiceRus() = listOf("плак", "плакать", "плачу", "плачешь", "плачет", "плачем", "плачут", "плакал", "плакала", "плакало", "плакали", "плачь", "плачьте", "плача", "плакав", "плачущий", "плачущего", "плачущая", "плак", "рыдать", "рыдаю", "рыдаешь", "рыдает", "рыдаем", "рыдает", "рыдают", "рыдал", "рыдала", "рыдало", "рыдали", "рыдай", "рыдайте", "рыдая", "рыдав", "рыдающий", "рыдающего", "рыдающему", "рыдающего", "рыдающим", "рыдающем", "рыдающая", "рыдающей", "рыдающую", "плакса", "плаксы", "плаксе", "плаксу", "плаксой", "плаксе", "плакс", "плаксам", "плаксами", "плаксах", "хныкать", "слеза", "слезы", "слезе", "слезой", "слезе", "слезам", "слезами", "слезах", "слезно", "слезинка", "слезка")
    override fun voiceEng() = listOf("cry", "crying", "cried", "cries", "tears", "tear")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("biblethump")
}
