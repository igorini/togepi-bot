package com.igorini.togepibot.commands.general.duel.spot.black

import com.igorini.togepibot.TogepiBot.Companion.percents
import com.igorini.togepibot.commands.general.duel.CommandException
import com.igorini.togepibot.commands.general.duel.crit.DoubleCrit
import com.igorini.togepibot.commands.general.duel.spot.black.bounty.*
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
        @JvmField val blackSpotCritBonus = 30
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
                sendMessageToChannel(channelName, "Чёрная метка ${blackSpotSymbol} на @${blackSpot.duelist.user.displayName}. За его/её голову назначена награда в ${blackSpot.bounty} хп. Шанс крита по метке увеличен с ${DoubleCrit.chance()}% до ${DoubleCrit.chance() + blackSpotCritBonus}%")
            }
        } catch (e: CommandException) {
            sendMessageToChannel(channelName, e.message)
            return
        }
    }

    private fun assignBlackSpot(channel: Channel) {
        val duelist = channel.duelists.filter { it.hp > 0 }.random()
        BlackSpots.upsert(channel, duelist, bounty().reward())
    }

    private fun bounty()  = when (percents.random()) {
        in 1..UltraBounty.chance() -> UltraBounty
        in (UltraBounty.chance() + 1)..MegaBounty.chance() -> MegaBounty
        in (MegaBounty.chance() + 1)..TripleBounty.chance() -> TripleBounty
        in (TripleBounty.chance() + 1)..DoubleBounty.chance() -> DoubleBounty
        else -> NormalBounty
    }
}