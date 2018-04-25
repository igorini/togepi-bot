package com.igorini.togepibot.commands.general.duel.top

import com.igorini.togepibot.model.Duelist
import me.philippheuer.twitch4j.message.commands.CommandPermission
import java.math.BigDecimal

/** Represents a command for showing duelists with the highest winrates */
class TopWinrate : Top() {
    companion object {
        @JvmField val minimumAmountOfDuels = 40
    }

    init {
        command = "винрейт"
        commandAliases = arrayOf("winrate", "Winrate", "WINRATE", "wr", "Винрейт", "ВИНРЕЙТ")
        category = "general"
        description = "Посмотреть топ винрейт дуэлянтов"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!винрейт"
    }

    override fun topMessage() = "Топ дуэлянтов по винрейту (минимум ${minimumAmountOfDuels} дуэлей)"
    override fun sort(duelists: List<Duelist>) = duelists.filter { it.duels >= minimumAmountOfDuels }.sortedByDescending { it.winrate }
    override fun stat(duelist: Duelist) = "${duelist.winrate.setScale(2, BigDecimal.ROUND_DOWN)}%"
    override fun type() = TopType.WINRATE
}