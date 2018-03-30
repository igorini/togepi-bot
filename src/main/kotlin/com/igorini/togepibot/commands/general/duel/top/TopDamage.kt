package com.igorini.togepibot.commands.general.duel.top

import com.igorini.togepibot.model.Duelist
import me.philippheuer.twitch4j.message.commands.CommandPermission

/** Represents a command for showing duelists with the highest maximum damage */
class TopDamage : Top() {
    init {
        command = "урон"
        commandAliases = arrayOf("Урон", "УРОН", "dmg", "DMG", "Dmg", "damage")
        category = "general"
        description = "урон"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!урон"
    }

    override fun topMessage() = "Топ дуэлянтов по максимальному урону"
    override fun sort(duelists: List<Duelist>) = duelists.sortedByDescending { it.maxDamage }
    override fun stat(duelist: Duelist) = duelist.maxDamage
}