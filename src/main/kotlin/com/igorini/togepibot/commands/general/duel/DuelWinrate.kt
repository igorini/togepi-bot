package com.igorini.togepibot.commands.general.duel

import com.igorini.togepibot.model.*
import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.message.commands.Command
import me.philippheuer.twitch4j.message.commands.CommandPermission
import org.jetbrains.exposed.sql.transactions.transaction
import java.math.BigDecimal

/** Represents a command that performs a duel against someone in chat */
class DuelWinrate : Command() {
    companion object {
        @JvmField val minimumAmountOfDuels = 10
        @JvmField val duelistsToDisplay = 3
    }

    init {
        command = "винрейт"
        commandAliases = arrayOf("winrate", "wr")
        category = "general"
        description = "Посмотреть топ винрейт дуэлянтов"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!винрейт"
    }

    override fun executeCommand(messageEvent: ChannelMessageEvent?) {
        super.executeCommand(messageEvent)

        val channelName = messageEvent!!.channel.name!!
        val username = messageEvent.user.name.toLowerCase()

        val sb = StringBuilder("Топ дуэлянтов по винрейту")

        transaction {
            val channel = Channels.findOrInsert(channelName)
            val user = Users.findOrInsert(username, messageEvent.user.displayName)
            val sortedDuelists = Duelist.all().filter { it.channel == channel }.sortedByDescending { it.winrate }
            if (sortedDuelists.isEmpty()) {
                throw IllegalArgumentException("Не найдено состоявшихся дуэлей")
            }

            val userFoughtEnoughDuels = userFoughtEnoughDuels(channel, user, sortedDuelists)
            if (!userFoughtEnoughDuels) sb.append(" (минимум $minimumAmountOfDuels дуэлей)")
            sb.append(":${topWinrate(sortedDuelists, channel, user, userFoughtEnoughDuels)}")
        }

        sendMessageToChannel(channelName, sb.toString())
    }

    private fun topWinrate(sortedDuelists: List<Duelist>, channel: Channel, user: User, userFoughtEnoughDuels: Boolean): String {
        val sb = StringBuilder(50)
        val top3 = sortedDuelists.filter { it.duels >= minimumAmountOfDuels }.take(duelistsToDisplay)
        top3.forEachIndexed { index, duelist -> sb.append(" ${index + 1}. ${duelist.user.displayName} - ${duelist.winrate.setScale(2, BigDecimal.ROUND_DOWN)}%") }

        if (userFoughtEnoughDuels && top3.none { it.channel == channel && it.user == user }) {
            sortedDuelists.withIndex().filter { it.value.channel == channel && it.value.user == user }.forEach { (index, duelist) -> sb.append(" ${index + 1}. ${duelist.user.displayName} - ${duelist.winrate.setScale(2, BigDecimal.ROUND_DOWN)}%") }
        }

        return sb.toString()
    }

    private fun userFoughtEnoughDuels(channel: Channel, user: User, sortedDuelists: List<Duelist>) = sortedDuelists.filter { it.channel == channel && it.user == user }.firstOrNull()?.let { it.duels >= minimumAmountOfDuels } ?: false
}