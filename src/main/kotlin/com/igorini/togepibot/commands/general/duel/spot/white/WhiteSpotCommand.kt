package com.igorini.togepibot.commands.general.duel.spot.white

import com.igorini.togepibot.commands.general.duel.CommandException
import com.igorini.togepibot.commands.general.duel.spot.white.buff.NormalBuff
import com.igorini.togepibot.ext.random
import com.igorini.togepibot.model.*
import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.message.commands.Command
import me.philippheuer.twitch4j.message.commands.CommandPermission
import mu.KotlinLogging
import org.jetbrains.exposed.sql.transactions.transaction

/** Represents */
class WhiteSpotCommand : Command() {

    companion object {
        const val whiteSpotSymbol = '○'
    }

    val logger = KotlinLogging.logger {}

    init {
        command = "белая"
        commandAliases = arrayOf("БЕЛАЯ", "Белая", "белая_метка", "white", "WHITE", "White", "white_spot")
        category = "general"
        description = "white"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!белая"
    }

    override fun executeCommand(messageEvent: ChannelMessageEvent?) {
        super.executeCommand(messageEvent)

        val channelName = messageEvent!!.channel.name!!

        try {
            transaction {
                val channel = Channels.findOrInsert(channelName)

                fun assignWhiteSpot() {
                    val duelist: Duelist
                    try {
                        duelist = channel.duelists.filter { it.hp <= 0 }.random()
                    } catch (e: NoSuchElementException) {
                        throw CommandException("Не удалось найти мертвых дуэлянтов.")
                    }
                    WhiteSpots.upsert(channel, duelist, NormalBuff.amount())
                }

                if (channel.whiteSpots.empty()) assignWhiteSpot()

                val whiteSpot = channel.whiteSpots.first()
                sendMessageToChannel(channelName, "Белая метка $whiteSpotSymbol на @${whiteSpot.duelist.user.displayName}. Воскресив его/её вы получите баф +${whiteSpot.critBuff}% к x2 криту на 15 мин.")
            }
        } catch (e: CommandException) {
            sendMessageToChannel(channelName, e.message)
            return
        }
    }
}