package com.igorini.togepibot.model

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

/** Represents a user model */
@Suppress("unused")
object Users : IntIdTable() {
    val name= varchar("name", 50)
    val displayName = varchar("displayName", 50).nullable()
    val bot = bool("bot").default(false)

    fun findOrInsert(username: String, userDisplayName: String): User {
        val result = User.find { name eq username }
        return if (result.empty()) {
            User.new {
                name = username
                displayName = userDisplayName
            }
        } else result.first()
    }
}

@Suppress("unused")
class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(Users)

    var name by Users.name
    var displayName by Users.displayName
    var bot by Users.bot
}