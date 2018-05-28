package com.igorini.togepibot.gui.keyword.anime.pokemon

import com.igorini.togepibot.gui.keyword.Keyword

/** Represents a keyword for text and sound associated with "Pokemon" */
object PokemonKeyword : Keyword() {
    override fun folder() = "anime\\pokemon"
    override fun voiceRus() = listOf("покемон", "покемона", "покемону", "покемоне", "покемоны", "покемонах", "покемонов", "покемончик", "покемончики")
    override fun voiceEng() = listOf("pokemon", "pokemons")
    override fun textRus() = voiceRus()
    override fun textEng() = voiceEng()
    override fun emotes() = listOf("pokemon")
}