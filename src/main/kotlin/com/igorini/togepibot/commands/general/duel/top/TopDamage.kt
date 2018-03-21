package com.igorini.togepibot.commands.general.duel.top

import com.igorini.togepibot.model.*
import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.message.commands.Command
import me.philippheuer.twitch4j.message.commands.CommandPermission
import org.jetbrains.exposed.sql.transactions.transaction

/** Represents */
class TopDamage : Command() {
    companion object {
        @JvmField val duelistsToDisplay = 3
    }

    init {
        command = "урон"
        commandAliases = arrayOf("Урон", "УРОН", "dmg", "DMG", "Dmg", "damage")
        category = "general"
        description = "урон"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!урон"
    }

    override fun executeCommand(messageEvent: ChannelMessageEvent?) {
        super.executeCommand(messageEvent)

        val channelName = messageEvent!!.channel.name!!
        val username = messageEvent.user.name.toLowerCase()

        val sb = StringBuilder("Топ дуэлянтов по максимальному урону")

        transaction {
            val channel = Channels.findOrInsert(channelName)
            val user = Users.findOrInsert(username, messageEvent.user.displayName)
            val sortedDuelists = Duelist.all().filter { it.channel == channel }.sortedByDescending { it.maxDamage }
            sb.append(maxHpTop(sortedDuelists, channel, user))
        }

        sendMessageToChannel(channelName, sb.toString())
    }

    private fun maxHpTop(sortedDuelists: List<Duelist>, channel: Channel, user: User): String {
        val sb = StringBuilder(50)
        val top3 = sortedDuelists.take(duelistsToDisplay)
        top3.forEachIndexed { index, duelist -> sb.append(" ${index + 1}. ${duelist.user.displayName}: ${duelist.maxDamage}") }

        if (top3.none { it.channel == channel && it.user == user }) {
            sortedDuelists.withIndex().filter { it.value.channel == channel && it.value.user == user }.forEach { (index, duelist) -> sb.append(" ${index + 1}. ${duelist.user.displayName}: ${duelist.maxDamage}") }
        }

        return sb.toString()
    }
}