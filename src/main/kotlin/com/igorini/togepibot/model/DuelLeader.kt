package com.igorini.togepibot.model

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

/** Represents a duelist top model */
@Suppress("unused")
object DuelLeaders : IntIdTable() {
    val channel = reference("channel", Channels)
    val duelist = reference("duelist", Duelists)
    val place = integer("place")

    fun upsert(dlChannel: Channel, dlDuelist: Duelist, dlPlace: Int) {
        val newDuelLeader = dlChannel.duelLeaders.find { it.place == dlPlace } ?:  DuelLeader.new {
            channel = dlChannel
            duelist = dlDuelist
            place = dlPlace
        }
        newDuelLeader.duelist = dlDuelist
    }
}

@Suppress("unused")
class DuelLeader(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<DuelLeader>(DuelLeaders)

    var channel by Channel referencedOn DuelLeaders.channel
    var duelist by Duelist referencedOn DuelLeaders.duelist
    var place by DuelLeaders.place
}