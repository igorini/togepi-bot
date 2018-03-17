package com.igorini.togepibot.model

import org.jetbrains.exposed.dao.*
import java.math.BigDecimal
import java.math.RoundingMode

/** Represents a duelist model */
@Suppress("unused")
object Duelists : IntIdTable() {
    val channel = reference("channel", Channels)
    val user = reference("user", Users)
    val duels = integer("duels").default(0)
    val wins = integer("wins").default(0)
    val losses = integer("losses").default(0)
    val winrate = decimal("winrate", 7, 4).default(BigDecimal.ZERO)
    val maxCrit = integer("max_crit").nullable()
}

@Suppress("unused")
class Duelist(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Duelist>(Duelists)

    var channel by Channel referencedOn Duelists.channel
    var user by User referencedOn Duelists.user
    var duels by Duelists.duels
    var wins by Duelists.wins
    var losses by Duelists.losses
    var winrate by Duelists.winrate
    var maxCrit by Duelists.maxCrit
}

fun Duelist.recalculateWinrate() = BigDecimal(wins.toString()).divide(BigDecimal(duels.toString()), 6, RoundingMode.HALF_UP).multiply(BigDecimal("100"))