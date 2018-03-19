package com.igorini.togepibot.commands.general.duel.crit

/** Represents a Double Crit (x2) */
object DoubleCrit : Crit {
    override fun multiplier() = 2.0
    override fun chance() = 20
    override fun nameAliases() = listOf("Критический урон")
    override fun emoteAliases() = listOf("KAPOW", "MorphinTime")
}