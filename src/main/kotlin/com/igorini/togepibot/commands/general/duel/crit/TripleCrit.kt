package com.igorini.togepibot.commands.general.duel.crit

/** Represents a Triple Crit (x3) */
object TripleCrit : Crit {
    override fun multiplier() = 3.0
    override fun chance() = 10
    override fun nameAliases() = listOf("Критический урон")
    override fun emoteAliases() = listOf("KAPOW KAPOW", "MorphinTime MorphinTime")
}