package com.igorini.togepibot.commands.general.duel

import com.igorini.kotlintwitchbot.ext.viewerOnlineExcept
import com.igorini.togepibot.TogepiBot
import com.igorini.togepibot.model.Channels
import com.igorini.togepibot.model.Duelist
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
        var targetUsername = messageEvent.user.name.toLowerCase()
        val words = messageEvent.message.split("\\s".toRegex())

        if (words.size > 1) {
            targetUsername = words[1].replaceFirst("^@".toRegex(), "").toLowerCase()
            if (!viewerOnlineExcept(messageEvent, targetUsername, TogepiBot.botUsers)) {
                sendMessageToChannel(channelName,"Пользователь $targetUsername в чате не найден, или он бот. Kappa")
                return
            }
        }

        transaction {
            val channel = Channels.findOrInsert(channelName)
            val user = Users.findOrInsert(targetUsername, messageEvent.user.displayName)
            val duelist = Duelist.all().firstOrNull { it.channel == channel && it.user == user }
            sendMessageToChannel(channelName, "У @${user.displayName} ${duelist?.hp ?: Duel.initialHP} хп")
        }
    }
}