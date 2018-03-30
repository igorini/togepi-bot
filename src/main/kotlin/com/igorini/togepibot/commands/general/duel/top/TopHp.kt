package com.igorini.togepibot.commands.general.duel.top

import com.igorini.togepibot.model.Duelist
import me.philippheuer.twitch4j.message.commands.CommandPermission

/** Represents a command for showing duelists with the highest current HP */
class TopHp : Top() {
    init {
        command = "топ"
        commandAliases = arrayOf("топчик", "дуэльтоп", "Топ", "ТОП", "top", "Top", "TOP")
        category = "general"
        description = "Топ дуэлянтов"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!топ"
    }

    override fun topMessage() = "Топ дуэлянтов по текущему хп"
    override fun sort(duelists: List<Duelist>) = duelists.sortedByDescending { it.hp }
    override fun stat(duelist: Duelist) = duelist.hp
}