package com.igorini.togepibot.commands.general

import com.igorini.togepibot.model.*
import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.message.commands.Command
import me.philippheuer.twitch4j.message.commands.CommandPermission
import org.jetbrains.exposed.sql.transactions.transaction
import java.math.BigDecimal

/** Represents a command that performs a duel against someone in chat */
class DuelTop : Command() {
    companion object {
        @JvmField val minimumAmountOfDuels = 5
        @JvmField val duelistsToDisplay = 3
    }

    init {
        command = "топ"
        commandAliases = arrayOf("топчик", "дуэльтоп")
        category = "general"
        description = "Посмотреть топ дуэлянтов"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!топ"
    }

    override fun executeCommand(messageEvent: ChannelMessageEvent?) {
        super.executeCommand(messageEvent)

        val channelName = messageEvent!!.channel.name!!
        val username = messageEvent.user.name.toLowerCase()

        val sb = StringBuilder("Топ дуэлянтов")

        transaction {
            val channel = findChannelOrInsert(channelName)
            val user = findUserOrInsert(username, messageEvent.user.displayName)
            val sortedDuelists = Duelist.all().filter { it.channel == channel }.sortedByDescending { it.winrate }
            if (sortedDuelists.isEmpty()) {
                throw IllegalArgumentException("Не найдено состоявшихся дуэлей")
            }

            val userFoughtEnoughDuels = userFoughtEnoughDuels(channel, user, sortedDuelists)
            if (!userFoughtEnoughDuels) sb.append(" (минимум 5 дуэлей)")
            sb.append(":${duelTop(sortedDuelists, channel, user, userFoughtEnoughDuels)}")
        }

        sendMessageToChannel(channelName, sb.toString())
    }

    private fun duelTop(sortedDuelists: List<Duelist>, channel: Channel, user: User, userFoughtEnoughDuels: Boolean): String {
        val sb = StringBuilder(50)
        val top3 = sortedDuelists.filter { it.duels >= minimumAmountOfDuels }.take(duelistsToDisplay)
        top3.forEachIndexed { index, duelist -> sb.append(" ${index + 1}. ${duelist.user.displayName} - ${duelist.winrate.setScale(2, BigDecimal.ROUND_DOWN)}%") }

        if (userFoughtEnoughDuels && top3.none { it.channel == channel && it.user == user }) {
            sortedDuelists.withIndex().filter { it.value.channel == channel && it.value.user == user }.forEach { (index, duelist) -> sb.append(" ${index + 1}. ${duelist.user.displayName} - ${duelist.winrate.setScale(2, BigDecimal.ROUND_DOWN)}%") }
        }

        return sb.toString()
    }

    private fun userFoughtEnoughDuels(channel: Channel, user: User, sortedDuelists: List<Duelist>) = sortedDuelists.filter { it.channel == channel && it.user == user }.firstOrNull()?.let { it.duels >= minimumAmountOfDuels } ?: false

    private fun findChannelOrInsert(channelName: String): Channel {
        val result = Channel.find { Channels.name eq channelName }
        return if (result.empty()) Channel.new { name = channelName } else result.first()
    }

    private fun findUserOrInsert(username: String, userDisplayName: String): User {
        val result = User.find { Users.name eq username }
        return if (result.empty()) {
            User.new {
                name = username
                displayName = userDisplayName
            }
        } else result.first()
    }
}