package com.igorini.togepibot.commands.general.duel.top

import com.igorini.togepibot.model.Duelist
import me.philippheuer.twitch4j.message.commands.CommandPermission

/** Represents a command for showing duelists with the highest amount of collected bounties */
class TopBounty : Top() {
    init {
        command = "награды"
        commandAliases = arrayOf("Награды", "НАГРАДЫ", "bounty", "BOUNTY", "Bounty", "награда", "bounties")
        category = "general"
        description = "награды"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!награды"
    }

    override fun topMessage() = "Топ дуэлянтов по сумме наград за черные метки"
    override fun sort(duelists: List<Duelist>) = duelists.sortedByDescending { it.totalBounty }
    override fun stat(duelist: Duelist) = duelist.totalBounty
    override fun type() = TopType.BOUNTY
}