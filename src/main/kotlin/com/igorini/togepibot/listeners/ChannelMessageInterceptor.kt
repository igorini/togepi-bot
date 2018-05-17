package com.igorini.togepibot.listeners

import com.igorini.togepibot.TogepiBot
import com.igorini.togepibot.gui.controllers.TogepiController
import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.events.EventSubscriber
import mu.KotlinLogging


/** Represents an interceptor on [ChannelMessageEvent] */
class ChannelMessageInterceptor {
    val logger = KotlinLogging.logger {}

    /** Subscribe to the ChannelMessage Event */
    @EventSubscriber
    fun onChannelMessage(event: ChannelMessageEvent) {
        val channel = event.channel.displayName
        val user = event.user.displayName
        val message = event.message

        logger.info("Channel [$channel] - User[$user] - Message [$message]")

        if (channel.toLowerCase() == TogepiBot.guiChannel && !(message.split("\\s".toRegex()).firstOrNull()?.startsWith('!') ?: false)) TogepiController.userMessagesBuffer.put(user.toLowerCase(), message)
    }
}