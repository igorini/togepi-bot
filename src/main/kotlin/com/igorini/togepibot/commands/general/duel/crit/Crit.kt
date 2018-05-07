package com.igorini.togepibot.commands.general.duel.crit

import com.igorini.togepibot.TogepiBot.Companion.percents
import com.igorini.togepibot.ext.random
import com.igorini.togepibot.ext.roundToInt

/** Represents */
interface Crit {
    companion object {
        fun proc(bonusChance: Int) = when (percents.random()) {
            in 1..UltraCrit.chance() -> UltraCrit
            in (UltraCrit.chance() + 1)..MegaCrit.chance() -> MegaCrit
            in (MegaCrit.chance() + 1)..TripleCrit.chance() -> TripleCrit
            in (TripleCrit.chance() + 1)..(DoubleCrit.chance() + bonusChance) -> DoubleCrit
            else -> null
        }
    }

    fun multiplier(): Double
    fun chance(): Int
    fun nameAliases(): List<String>
    fun emoteAliases(): List<String>
    fun stunSec(): Int
    fun message() = "${nameAliases().random()} (x${multiplier().roundToInt()})! ${emoteAliases().random()}"
    fun damage(base: Double) = (base * multiplier()).roundToInt()
}