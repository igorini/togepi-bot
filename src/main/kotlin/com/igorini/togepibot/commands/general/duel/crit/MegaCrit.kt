package com.igorini.togepibot.commands.general.duel.crit

/** Represents a Mega Crit */
object MegaCrit : Crit {
    override fun multiplier() = 5.0
    override fun chance() = 5
    override fun nameAliases() = listOf("Критический урон")
    override fun emoteAliases() = listOf("KAPOW KAPOW KAPOW", "MorphinTime MorphinTime MorphinTime")
}