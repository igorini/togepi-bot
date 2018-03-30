package com.igorini.togepibot.commands.general.duel.top

import com.igorini.togepibot.model.Duelist
import me.philippheuer.twitch4j.message.commands.CommandPermission

/** Represents a command for showing duelists with the highest amount of duels */
class TopDuels : Top() {
    init {
        command = "дуэли"
        commandAliases = arrayOf("Дуэли", "ДУЭЛИ", "duels", "DUELS", "Duels")
        category = "general"
        description = "дуэли"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!дуэли"
    }

    override fun topMessage() = "Топ дуэлянтов по количеству дуэлей"
    override fun sort(duelists: List<Duelist>) = duelists.sortedByDescending { it.duels }
    override fun stat(duelist: Duelist) = duelist.duels
    override fun type() = TopType.DUELS
}