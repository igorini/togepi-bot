package com.igorini.togepibot.model

import org.jetbrains.exposed.sql.Table

/** Represents a channel model */
@Suppress("unused")
object Channels : Table() {
    val name= varchar("name", 50).primaryKey()
}