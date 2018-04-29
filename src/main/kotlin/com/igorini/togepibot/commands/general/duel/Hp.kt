package com.igorini.togepibot.commands.general.duel

import com.igorini.togepibot.TogepiBot.Companion.botUsers
import com.igorini.togepibot.model.Channels
import com.igorini.togepibot.model.Duelist
import com.igorini.togepibot.model.User
import com.igorini.togepibot.model.Users
import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.message.commands.Command
import me.philippheuer.twitch4j.message.commands.CommandPermission
import mu.KotlinLogging
import org.jetbrains.exposed.sql.transactions.transaction

/** Represents */
class Hp : Command() {
    val logger = KotlinLogging.logger {}

    init {
        command = "хп"
        commandAliases = arrayOf("ХП", "hp", "HP")
        category = "general"
        description = "хп"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!хп"
    }

    override fun executeCommand(messageEvent: ChannelMessageEvent?) {
        super.executeCommand(messageEvent)

        val channelName = messageEvent!!.channel.name!!
        var targetUsername: String
        val words = messageEvent.message.split("\\s".toRegex())

        try {
            transaction {
                val channel = Channels.findOrInsert(channelName)

                val user: User
                if (words.size > 1) {
                    targetUsername = words[1].replaceFirst("^@".toRegex(), "").trim().toLowerCase()
                    val userFound: (Duelist) -> Boolean = { !botUsers.contains(it.user.name) && (it.user.name == targetUsername || it.user.displayName?.toLowerCase() == targetUsername) }

                    if (channel.duelists.none(userFound)) throw CommandException("Пользователь $targetUsername не найден")

                    user = Users.findOrInsert(targetUsername, targetUsername)
                } else {
                    user = Users.findOrInsert(messageEvent.user.displayName.toLowerCase(), messageEvent.user.displayName)
                }

                val duelist = Duelist.all().firstOrNull { it.channel == channel && it.user == user }
                sendMessageToChannel(channelName, "У @${user.displayName} ${duelist?.hp ?: Duel.initialHP} хп")
            }
        } catch (e: CommandException) {
            sendMessageToChannel(channelName, e.message)
            return
        }
    }
}