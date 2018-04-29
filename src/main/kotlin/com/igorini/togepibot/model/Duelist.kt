package com.igorini.togepibot.model

import com.igorini.togepibot.commands.general.duel.Duel
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
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
    val resurrects = integer("resurrects").default(0)
    val available = datetime("available").nullable()
    val totalBounty = integer("total_bounty").default(0)
    val critBuff = integer("crit_buff").default(0)
    val critBuffUntil = datetime("crit_buff_until").nullable()
    val preferredTitle = varchar("preferred_title", 50).nullable()
    val deadUntil = datetime("dead_until").nullable()

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
    var resurrects by Duelists.resurrects
    var available by Duelists.available
    var totalBounty by Duelists.totalBounty
    var critBuff by Duelists.critBuff
    var critBuffUntil by Duelists.critBuffUntil
    var preferredTitle by Duelists.preferredTitle
    var deadUntil by Duelists.deadUntil
}

fun Duelist.recalculateWinrate() = BigDecimal(wins.toString()).divide(BigDecimal(duels.toString()), 6, RoundingMode.HALF_UP).multiply(BigDecimal("100"))