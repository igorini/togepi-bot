package com.igorini.togepibot.model

import org.jetbrains.exposed.sql.Table

/** Represents a user model */
object Users : Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val name= Channels.varchar("name", 50)
    val bot = bool("bot").default(false)
}