package com.igorini.togepibot.model

import com.igorini.togepibot.model.Duelists.default
import com.igorini.togepibot.model.Duelists.nullable
import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.sql.Table
import java.math.BigDecimal

/** Represents a duelist model */
@Suppress("unused")
object Duelists : IntIdTable() {
    val channelName = reference("channel_name", Channels)
    val userName = reference("user_name", Users)
    val duels = integer("duels").default(0)
    val wins = integer("wins").default(0)
    val losses = integer("losses").default(0)
    val winrate = decimal("winrate", 6, 4).default(BigDecimal.ZERO)
    val maxCrit = integer("max_crit").nullable()
}

@Suppress("unused")
class Duelist(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Duelist>(Duelists)

    var channelName by Duelists.channelName
    var userName by Duelists.userName
    var duels by Duelists.duels
    var wins by Duelists.wins
    var losses by Duelists.losses
    var winrate by Duelists.winrate
    var maxCrit by Duelists.maxCrit
}