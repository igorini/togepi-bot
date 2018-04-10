package com.igorini.togepibot.commands.general.duel.spot.black.bounty

/** Represents a normal bounty */
object NormalBounty : Bounty {
    override fun reward() = 100
    override fun chance() = 50
}