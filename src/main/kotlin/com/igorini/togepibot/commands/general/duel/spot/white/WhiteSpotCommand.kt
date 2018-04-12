package com.igorini.togepibot.commands.general.duel.spot.white

import com.igorini.togepibot.TogepiBot.Companion.percents
import com.igorini.togepibot.commands.general.duel.CommandException
import com.igorini.togepibot.commands.general.duel.spot.white.buff.*
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
        @JvmField val buffDurationMins = 15
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

                if (channel.whiteSpots.empty()) assignWhiteSpot(channel)

                val whiteSpot = channel.whiteSpots.first()
                sendMessageToChannel(channelName, "Белая метка $whiteSpotSymbol на @${whiteSpot.duelist.user.displayName}. Воскресив его/её вы получите баф +${whiteSpot.critBuff}% к шансу крита на $buffDurationMins мин.")
            }
        } catch (e: CommandException) {
            sendMessageToChannel(channelName, e.message)
            return
        }
    }

    private fun assignWhiteSpot(channel: Channel) {
        val duelist: Duelist
        try {
            duelist = channel.duelists.filter { it.hp <= 0 }.random()
        } catch (e: NoSuchElementException) {
            throw CommandException("Мёртвых дуэлянтов не обнаружено.")
        }
        WhiteSpots.upsert(channel, duelist, buff().amount())
    }

    private fun buff()  = when (percents.random()) {
        in 1..UltraBuff.chance() -> UltraBuff
        in (UltraBuff.chance() + 1)..MegaBuff.chance() -> MegaBuff
        in (MegaBuff.chance() + 1)..TripleBuff.chance() -> TripleBuff
        in (TripleBuff.chance() + 1)..DoubleBuff.chance() -> DoubleBuff
        else -> NormalBuff
    }
}