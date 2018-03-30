package com.igorini.togepibot.commands.general.duel.top

import com.igorini.togepibot.model.*
import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.message.commands.Command
import org.jetbrains.exposed.sql.transactions.transaction

/** Represents an abstract top (leaderboard) command for Duelists */
abstract class Top : Command() {
    companion object {
        @JvmField val duelistsToDisplay = 3
    }

    override fun executeCommand(messageEvent: ChannelMessageEvent?) {
        super.executeCommand(messageEvent)

        val channelName = messageEvent!!.channel.name!!
        val username = messageEvent.user.name.toLowerCase()

        val sb = StringBuilder(topMessage())

        transaction {
            val channel = Channels.findOrInsert(channelName)
            val user = Users.findOrInsert(username, messageEvent.user.displayName)
            val sortedDuelists = sort(Duelist.all().filter { it.channel == channel })
            sb.append(top(sortedDuelists, channel, user))
        }

        sendMessageToChannel(channelName, sb.toString())
    }

    private fun top(sortedDuelists: List<Duelist>, channel: Channel, user: User): String {
        val sb = StringBuilder(50)

        fun displayStat(index: Int, duelist: Duelist) = sb.append(" [${index + 1}. ${duelist.user.displayName}: ${stat(duelist)}]")

        val top3 = sortedDuelists.take(duelistsToDisplay)

        fun updateDB() = top3.firstOrNull()?.let { DuelTops.upsert(channel, it, type()) }

        updateDB()

        top3.forEachIndexed { index, duelist -> displayStat(index, duelist) }

        if (top3.none { it.channel == channel && it.user == user }) {
            sortedDuelists.withIndex()
                    .filter { it.value.channel == channel && it.value.user == user }
                    .forEach { (index, duelist) -> displayStat(index, duelist) }
        }

        return sb.toString()
    }

    abstract fun topMessage(): String
    abstract fun sort(duelists: List<Duelist>): List<Duelist>
    abstract fun stat(duelist: Duelist): Any
    abstract fun type(): TopType
}