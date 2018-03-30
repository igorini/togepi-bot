package com.igorini.togepibot.commands.general.duel.top

import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.message.commands.Command
import me.philippheuer.twitch4j.message.commands.CommandPermission

/** Represents */
class Tops : Command() {
    init {
        command = "топы"
        commandAliases = arrayOf("Топы", "ТОПЫ", "tops", "Tops", "TOPS") // TODO: Refactor kotlin-twitch-bot to be case incensitive
        category = "general"
        description = "Топы"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!топы"
    }

    override fun executeCommand(messageEvent: ChannelMessageEvent?) {
        super.executeCommand(messageEvent)

        val channelName = messageEvent!!.channel.name!!

        // TODO: Refactor Top classes to beans and obtain commands from them
        sendMessageToChannel(channelName, "!top/топ (текущее хп), !maxhp/максхп, !wr/винрейт, !dmg/урон, !kills/убийства, !deaths/смерти, !res/рес (воскрешения), !duels/дуэли (количество сыгранных дуэлей)")
    }
}