package com.igorini.togepibot.commands.general.duel.spot.black

import com.igorini.kotlintwitchbot.ext.randomViewerExcept
import com.igorini.togepibot.TogepiBot.Companion.botUsers
import com.igorini.togepibot.commands.general.duel.CommandException
import com.igorini.togepibot.commands.general.duel.spot.black.bounty.NormalBounty
import com.igorini.togepibot.ext.random
import com.igorini.togepibot.model.*
import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.message.commands.Command
import me.philippheuer.twitch4j.message.commands.CommandPermission
import mu.KotlinLogging
import org.jetbrains.exposed.sql.transactions.transaction

/** Represents */
class BlackSpotCommand : Command() {

    companion object {
        const val blackSpotSymbol = '●'

        fun assignBlackSpot(channel: Channel) {
            val duelist = channel.duelists.filter { it.hp > 0 }.random()
            BlackSpots.upsert(channel, duelist, NormalBounty.reward())
        }
    }

    val logger = KotlinLogging.logger {}

    init {
        command = "черная"
        commandAliases = arrayOf("ЧЕРНАЯ", "Черная", "чёрная", "черная_метка", "чёрная_метка", "black", "BLACK", "Black", "black_spot")
        category = "general"
        description = "черная"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!черная"
    }

    override fun executeCommand(messageEvent: ChannelMessageEvent?) {
        super.executeCommand(messageEvent)

        val channelName = messageEvent!!.channel.name!!

        try {
            transaction {
                val channel = Channels.findOrInsert(channelName)

                if (channel.blackSpots.empty()) assignBlackSpot(channel)

                val blackSpot = channel.blackSpots.first()
                sendMessageToChannel(channelName, "Чёрная метка ${blackSpotSymbol} на @${blackSpot.duelist.user.displayName}. За его/её голову назначена награда в ${blackSpot.bounty} хп.")
            }
        } catch (e: CommandException) {
            sendMessageToChannel(channelName, e.message)
            return
        }
    }
}