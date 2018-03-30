package com.igorini.togepibot.commands.general.duel.top

import com.igorini.togepibot.model.Duelist
import me.philippheuer.twitch4j.message.commands.CommandPermission

/** Represents a command for showing duelists with the highest maximum HP */
class TopMaxHp : Top() {
    init {
        command = "рекорд"
        commandAliases = arrayOf("Рекорд", "РЕКОРД", "максхп", "record", "maxhp")
        category = "general"
        description = "Рекорд по максимальному хп"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!рекорд"
    }

    override fun topMessage() = "Топ дуэлянтов по максимальному хп"
    override fun sort(duelists: List<Duelist>) = duelists.sortedByDescending { it.maxHp }
    override fun stat(duelist: Duelist) = duelist.maxHp
}