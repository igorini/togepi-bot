package com.igorini.togepibot.model

import org.jetbrains.exposed.sql.Table

/** Represents a user model */
@Suppress("unused")
object Users : Table() {
    val name= varchar("name", 50).primaryKey()
    val displayName = varchar("displayName", 50).nullable()
    val bot = bool("bot").default(false)
}