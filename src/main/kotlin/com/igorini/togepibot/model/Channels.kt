package com.igorini.togepibot.model

import org.jetbrains.exposed.sql.Table

/** Represents a channel model */
@Suppress("unused")
object Channels : Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val name= varchar("name", 50)
}