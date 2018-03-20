package com.igorini.togepibot.commands.general.duel.crit

import kotlin.math.roundToInt

/** Represents a Mega Crit */
object MegaCrit : Crit {
    override fun multiplier() = 5.0
    override fun chance() = 5
    override fun nameAliases() = listOf("Критический урон")
    override fun emoteAliases() = listOf("KAPOW KAPOW KAPOW", "MorphinTime MorphinTime MorphinTime")
    override fun stunSec() = 60 * multiplier().roundToInt()
}