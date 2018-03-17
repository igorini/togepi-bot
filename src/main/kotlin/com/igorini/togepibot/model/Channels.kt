package com.igorini.togepibot.model

import org.jetbrains.exposed.sql.Table

/** Represents a channel model */
object Channels : Table() {
    val id = Users.integer("id").autoIncrement().primaryKey()
    val name= varchar("name", 50)
}