package com.igorini.togepibot.model

import org.jetbrains.exposed.sql.Table
import java.math.BigDecimal

/** Represents a duelist model */
@Suppress("unused")
object Duelists : Table() {
    val channelName = varchar("channel_name", 50).primaryKey(0) references Channels.name
    val userName = varchar("user_name", 50).primaryKey(1) references Users.name
    val duels = integer("duels").default(0)
    val wins = integer("wins").default(0)
    val losses = integer("losses").default(0)
    val winrate = decimal("winrate", 6, 4).default(BigDecimal.ZERO)
    val maxCrit = integer("max_crit").nullable()
}