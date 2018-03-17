package com.igorini.togepibot.model

import org.jetbrains.exposed.sql.Table
import java.math.BigDecimal

/** Represents a duelist model */
@Suppress("unused")
object Duelists : Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val userId = integer("user_id") references Users.id
    val channelId = integer("channel_id") references Channels.id
    val duels = integer("duels").default(0)
    val wins = integer("wins").default(0)
    val losses = integer("losses").default(0)
    val winrate = decimal("winrate", 6, 4).default(BigDecimal.ZERO)
    val maxCrit = integer("max_crit").nullable()
}