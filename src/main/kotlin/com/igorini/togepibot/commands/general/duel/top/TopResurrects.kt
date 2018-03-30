package com.igorini.togepibot.commands.general.duel.top

import com.igorini.togepibot.model.Duelist
import me.philippheuer.twitch4j.message.commands.CommandPermission

/** Represents a command for showing duelists with the highest amount of resurrections */
class TopResurrects : Top() {
    init {
        command = "рес"
        commandAliases = arrayOf("РЕС", "Рес", "res", "RES", "Res", "воскрешения", "resurrects")
        category = "general"
        description = "рес"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!рес"
    }

    override fun topMessage() = "Топ дуэлянтов по количеству воскрешений"
    override fun sort(duelists: List<Duelist>) = duelists.sortedByDescending { it.resurrects }
    override fun stat(duelist: Duelist) = duelist.resurrects
    override fun type() = TopType.RESURRECTS
}