package com.igorini.togepibot.commands.general.duel.top

import com.igorini.togepibot.model.*
import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.message.commands.Command
import me.philippheuer.twitch4j.message.commands.CommandPermission
import org.jetbrains.exposed.sql.transactions.transaction

/** Represents */
class TopRessurects : Command() {
    companion object {
        @JvmField val duelistsToDisplay = 3
    }

    init {
        command = "рес"
        commandAliases = arrayOf("РЕС", "Рес", "res", "RES", "Res", "воскрешения", "ressurects")
        category = "general"
        description = "рес"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!рес"
    }

    override fun executeCommand(messageEvent: ChannelMessageEvent?) {
        super.executeCommand(messageEvent)

        val channelName = messageEvent!!.channel.name!!
        val username = messageEvent.user.name.toLowerCase()

        val sb = StringBuilder("Топ дуэлянтов по количеству воскрешений")

        transaction {
            val channel = Channels.findOrInsert(channelName)
            val user = Users.findOrInsert(username, messageEvent.user.displayName)
            val sortedDuelists = Duelist.all().filter { it.channel == channel }.sortedByDescending { it.ressurects }
            sb.append(maxHpTop(sortedDuelists, channel, user))
        }

        sendMessageToChannel(channelName, sb.toString())
    }

    private fun maxHpTop(sortedDuelists: List<Duelist>, channel: Channel, user: User): String {
        val sb = StringBuilder(50)
        val top3 = sortedDuelists.take(duelistsToDisplay)
        top3.forEachIndexed { index, duelist -> sb.append(" ${index + 1}. ${duelist.user.displayName}: ${duelist.ressurects}") }

        if (top3.none { it.channel == channel && it.user == user }) {
            sortedDuelists.withIndex().filter { it.value.channel == channel && it.value.user == user }.forEach { (index, duelist) -> sb.append(" ${index + 1}. ${duelist.user.displayName}: ${duelist.ressurects}") }
        }

        return sb.toString()
    }
}