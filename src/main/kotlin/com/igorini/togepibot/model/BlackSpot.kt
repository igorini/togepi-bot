package com.igorini.togepibot.model

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

/** Represents a black spot model */
@Suppress("unused")
object BlackSpots : IntIdTable() {
    val channel = reference("channel", Channels)
    val duelist = reference("duelist", Duelists)
    val bounty = integer("bounty")

    fun upsert(bsChannel: Channel, bsDuelist: Duelist, bsBounty: Int) {
        val newBlackSpot = bsChannel.blackSpots.firstOrNull() ?:  BlackSpot.new {
            channel = bsChannel
            duelist = bsDuelist
            bounty = bsBounty
        }
        newBlackSpot.duelist = bsDuelist
        newBlackSpot.bounty = bsBounty
    }
}

@Suppress("unused")
class BlackSpot(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<BlackSpot>(BlackSpots)

    var channel by Channel referencedOn BlackSpots.channel
    var duelist by Duelist referencedOn BlackSpots.duelist
    var bounty by BlackSpots.bounty
}