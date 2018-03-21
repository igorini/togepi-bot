package com.igorini.togepibot.commands.general.duel.top

import com.igorini.togepibot.model.*
import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.message.commands.Command
import me.philippheuer.twitch4j.message.commands.CommandPermission
import org.jetbrains.exposed.sql.transactions.transaction

/** Represents */
class TopDuels : Command() {
    companion object {
        @JvmField val duelistsToDisplay = 3
    }

    init {
        command = "дуэли"
        commandAliases = arrayOf("Дуэли", "ДУЭЛИ", "duels", "DUELS", "Duels")
        category = "general"
        description = "дуэли"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!дуэли"
    }

    override fun executeCommand(messageEvent: ChannelMessageEvent?) {
        super.executeCommand(messageEvent)

        val channelName = messageEvent!!.channel.name!!
        val username = messageEvent.user.name.toLowerCase()

        val sb = StringBuilder("Топ дуэлянтов по количеству дуэлей")

        transaction {
            val channel = Channels.findOrInsert(channelName)
            val user = Users.findOrInsert(username, messageEvent.user.displayName)
            val sortedDuelists = Duelist.all().filter { it.channel == channel }.sortedByDescending { it.duels }
            sb.append(maxHpTop(sortedDuelists, channel, user))
        }

        sendMessageToChannel(channelName, sb.toString())
    }

    private fun maxHpTop(sortedDuelists: List<Duelist>, channel: Channel, user: User): String {
        val sb = StringBuilder(50)
        val top3 = sortedDuelists.take(duelistsToDisplay)
        top3.forEachIndexed { index, duelist -> sb.append(" ${index + 1}. ${duelist.user.displayName}: ${duelist.duels}") }

        if (top3.none { it.channel == channel && it.user == user }) {
            sortedDuelists.withIndex().filter { it.value.channel == channel && it.value.user == user }.forEach { (index, duelist) -> sb.append(" ${index + 1}. ${duelist.user.displayName}: ${duelist.duels}") }
        }

        return sb.toString()
    }
}