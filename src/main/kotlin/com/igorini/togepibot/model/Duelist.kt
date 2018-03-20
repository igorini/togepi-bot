package com.igorini.togepibot.model

import com.igorini.togepibot.commands.general.duel.Duel
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
    val hp = integer("hp").default(Duel.initialHP)
    val maxDamage = integer("max_damage").default(0)
    val maxHp = integer("max_hp").default(Duel.initialHP)
    val kills = integer("kills").default(0)
    val deaths = integer("deaths").default(0)
    val ressurects = integer("ressurects").default(0)
    val available = datetime("available").nullable()

    fun findOrInsert(duelistUser: User, duelistChannel: Channel) = duelistChannel.duelists.find { it.user == duelistUser } ?: Duelist.new {
        channel = duelistChannel
        user = duelistUser
    }
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
    var hp by Duelists.hp
    var maxDamage by Duelists.maxDamage
    var maxHp by Duelists.maxHp
    var kills by Duelists.kills
    var deaths by Duelists.deaths
    var ressurects by Duelists.ressurects
    var available by Duelists.available
}

fun Duelist.recalculateWinrate() = BigDecimal(wins.toString()).divide(BigDecimal(duels.toString()), 6, RoundingMode.HALF_UP).multiply(BigDecimal("100"))