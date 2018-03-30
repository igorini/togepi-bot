package com.igorini.togepibot.commands.general.duel.top

import com.igorini.togepibot.model.Duelist
import me.philippheuer.twitch4j.message.commands.CommandPermission

/** Represents a command for showing duelists with the highest amount of deaths */
class TopDeaths : Top() {
    init {
        command = "смерти"
        commandAliases = arrayOf("Смерти", "СМЕРТИ", "deaths", "DEATHS", "Deaths", "смерть", "death")
        category = "general"
        description = "смерти"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!смерти"
    }

    override fun topMessage() = "Топ дуэлянтов по количеству смертей"
    override fun sort(duelists: List<Duelist>) = duelists.sortedByDescending { it.deaths }
    override fun stat(duelist: Duelist) = duelist.deaths
}