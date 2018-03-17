package com.igorini.togepibot.model

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

/** Represents a channel model */
@Suppress("unused")
object Channels : IntIdTable() {
    val name= varchar("name", 50)
}

@Suppress("unused")
class Channel(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Channel>(Channels)

    var name by Channels.name
}

