package com.igorini.togepibot.gui.keyword

/** Represents a keyword for text and sound associated with "Scared" */
object ScaredKeyword : Keyword() {
    override fun folder() = "scared"
    override fun voiceRus() = listOf("страшно", "боюсь", "испугался", "напуган", "испуг", "страх", "страха", "страху", "страхом", "страхе", "страшный", "страшному", "страшным", "страшном", "страшная", "страшной", "страшную", "страшное", "страшные", "страшных", "страшным", "страшными", "страшен", "страшна", "испугалась", "пугался", "пугалась", "испугом")
    override fun voiceEng() = listOf("scared", "fear", "scary", "spooky")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("scaredycat")
}
