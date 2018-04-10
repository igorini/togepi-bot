package com.igorini.togepibot.model

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

/** Represents a white spot model */
@Suppress("unused")
object WhiteSpots : IntIdTable() {
    val channel = reference("channel", Channels)
    val duelist = reference("duelist", Duelists)
    val critBuff = integer("crit_buff")

    fun upsert(wsChannel: Channel, wsDuelist: Duelist, wsCritBuff: Int) {
        val newWhiteSpot = wsChannel.whiteSpots.firstOrNull() ?:  WhiteSpot.new {
            channel = wsChannel
            duelist = wsDuelist
            critBuff = wsCritBuff
        }
        newWhiteSpot.duelist = wsDuelist
        newWhiteSpot.critBuff = wsCritBuff
    }
}

@Suppress("unused")
class WhiteSpot(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<WhiteSpot>(WhiteSpots)

    var channel by Channel referencedOn WhiteSpots.channel
    var duelist by Duelist referencedOn WhiteSpots.duelist
    var critBuff by WhiteSpots.critBuff
}