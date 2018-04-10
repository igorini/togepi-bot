package com.igorini.togepibot.commands.general.duel.spot.white.buff

/** Represents a normal buff */
object NormalBuff : Buff {
    override fun amount() = 1
    override fun chance() = 20
}