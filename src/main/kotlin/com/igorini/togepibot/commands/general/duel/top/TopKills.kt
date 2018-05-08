package com.igorini.togepibot.commands.general.duel.top

import com.igorini.togepibot.model.Duelist
import me.philippheuer.twitch4j.message.commands.CommandPermission

/** Represents a command for showing duelists with the highest amount of kills */
class TopKills : Top() {
    init {
        command = "убийства"
        commandAliases = arrayOf("Убийства", "УБИЙСТВА", "kills", "KILLS", "Kills", "убийство")
        category = "general"
        description = "убийства"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!убийства"
    }

    override fun topMessage() = "Топ дуэлянтов по количеству убийств"
    override fun sort(duelists: List<Duelist>) = duelists.sortedByDescending { it.kills }
    override fun stat(duelist: Duelist) = duelist.kills
    override fun type() = TopType.KILLS
}