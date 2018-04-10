package com.igorini.togepibot.commands.general.duel.spot.black.bounty

/** Represents a bounty */
interface Bounty {
    fun reward(): Int
    fun chance(): Int
}