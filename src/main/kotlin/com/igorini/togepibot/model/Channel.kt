package com.igorini.togepibot.model

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

/** Represents a channel model */
@Suppress("unused")
object Channels : IntIdTable() {
    val name= varchar("name", 50)

    fun findOrInsert(channelName: String): Channel {
        val result = Channel.find { name eq channelName }
        return if (result.empty()) Channel.new { name = channelName } else result.first()
    }
}

@Suppress("unused")
class Channel(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Channel>(Channels)

    var name by Channels.name
    val duelists by Duelist referrersOn Duelists.channel
    val duelTops by DuelTop referrersOn DuelTops.channel
    val duelLeaders by DuelLeader referrersOn DuelLeaders.channel
    val blackSpots by BlackSpot referrersOn BlackSpots.channel
    val whiteSpots by WhiteSpot referrersOn WhiteSpots.channel
}

/** Transforms a list of usernames into a list of duelists. Creates duelists and users if they were not present */
fun Channel.duelists(viewers: List<String>) = viewers.map { Duelists.findOrInsert(Users.findOrInsert(it, it), this) }