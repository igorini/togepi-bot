package com.igorini.togepibot.commands.general.duel.spot.white.buff

/** Represents a buff */
interface Buff {
    fun amount(): Int
    fun chance(): Int
}