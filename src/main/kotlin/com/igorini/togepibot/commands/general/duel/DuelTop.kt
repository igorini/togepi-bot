package com.igorini.togepibot.commands.general.duel

import com.igorini.togepibot.model.*
import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.message.commands.Command
import me.philippheuer.twitch4j.message.commands.CommandPermission
import org.jetbrains.exposed.sql.transactions.transaction
import java.math.BigDecimal

/** Represents */
class DuelTop : Command() {
    companion object {
        @JvmField val duelistsToDisplay = 3
    }

    init {
        command = "топ"
        commandAliases = arrayOf("топчик", "дуэльтоп", "Топ", "ТОП")
        category = "general"
        description = "Топ дуэлянтов"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!топ"
    }

    override fun executeCommand(messageEvent: ChannelMessageEvent?) {
        super.executeCommand(messageEvent)

        val channelName = messageEvent!!.channel.name!!
        val username = messageEvent.user.name.toLowerCase()

        val sb = StringBuilder("Топ дуэлянтов по хп")

        transaction {
            val channel = Channels.findOrInsert(channelName)
            val user = Users.findOrInsert(username, messageEvent.user.displayName)
            val sortedDuelists = Duelist.all().filter { it.channel == channel }.sortedByDescending { it.hp }
            sb.append(":${hpTop(sortedDuelists, channel, user)}")
        }

        sendMessageToChannel(channelName, sb.toString())
    }

    private fun hpTop(sortedDuelists: List<Duelist>, channel: Channel, user: User): String {
        val sb = StringBuilder(50)
        val top3 = sortedDuelists.take(duelistsToDisplay)
        top3.forEachIndexed { index, duelist -> sb.append(" ${index + 1}. ${duelist.user.displayName} - ${duelist.hp}") }

        if (top3.none { it.channel == channel && it.user == user }) {
            sortedDuelists.withIndex().filter { it.value.channel == channel && it.value.user == user }.forEach { (index, duelist) -> sb.append(" ${index + 1}. ${duelist.user.displayName} - ${duelist.hp}") }
        }

        return sb.toString()
    }
}