package com.igorini.togepibot.model

import com.igorini.togepibot.commands.general.duel.top.TopType
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

/** Represents a duelist top model */
@Suppress("unused")
object DuelTops : IntIdTable() {
    val channel = reference("channel", Channels)
    val duelist = reference("duelist", Duelists)
    val type = enumeration("type", TopType::class.java)

    fun upsert(dtChannel: Channel, dtDuelist: Duelist, dtType: TopType) {
        val top = dtChannel.duelTops.find { it.type == dtType } ?: DuelTop.new {
            channel = dtChannel
            duelist = dtDuelist
            type = dtType
        }
        top.duelist = dtDuelist
    }
}

@Suppress("unused")
class DuelTop(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<DuelTop>(DuelTops)

    var channel by Channel referencedOn DuelTops.channel
    var duelist by Duelist referencedOn DuelTops.duelist
    var type by DuelTops.type
}