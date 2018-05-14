package com.igorini.togepibot.gui.keyword.animal

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Squirrel" */
object SquirrelKeyword : Keyword() {
    override fun folder() = "animal\\squirrel"
    override fun voiceRus() = listOf("белка", "белку", "белке", "белкой", "белки", "белкам", "белок", "белками", "белках", "белочка", "белочке", "белочку", "белочкой", "белочки", "белочек", "белочкам", "белочках", "белочками")
    override fun voiceEng() = listOf("squirrel")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("squirrel")
}