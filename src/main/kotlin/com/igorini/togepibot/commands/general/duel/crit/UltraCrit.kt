package com.igorini.togepibot.commands.general.duel.crit

/** Represents an Ultra Crit */
object UltraCrit  : Crit {
    override fun multiplier() = 9.0
    override fun chance() = 1
    override fun nameAliases() = listOf("Критический урон")
    override fun emoteAliases() = listOf("KAPOW KAPOW KAPOW KAPOW KAPOW", "MorphinTime MorphinTime MorphinTime MorphinTime MorphinTime")
}