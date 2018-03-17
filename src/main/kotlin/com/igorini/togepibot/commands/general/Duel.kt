package com.igorini.togepibot.commands.general

import com.igorini.kotlintwitchbot.ext.randomViewerExcept
import com.igorini.kotlintwitchbot.ext.viewerOnlineExcept
import com.igorini.togepibot.TogepiBot.Companion.botUsers
import com.igorini.togepibot.TogepiBot.Companion.negativeEmotes
import com.igorini.togepibot.TogepiBot.Companion.positiveEmotes
import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent
import me.philippheuer.twitch4j.message.commands.Command
import me.philippheuer.twitch4j.message.commands.CommandPermission

/** Represents a command that performs a duel against someone in chat */
class Duel : Command() {
    init {
        command = "дуэль"
        commandAliases = arrayOf("duel", "fight", "поединок", "махач", "бой", "битва", "борьба", "вызов", "вызываю", "драка")
        category = "general"
        description = "Вызовите оппонента на дуэль"
        requiredPermissions.add(CommandPermission.EVERYONE)
        usageExample = "!дуэль @username"
    }

    override fun executeCommand(messageEvent: ChannelMessageEvent?) {
        super.executeCommand(messageEvent)

        val channelName = messageEvent!!.channel.name
        val words = messageEvent.message.split("\\s".toRegex())

        val username = messageEvent.user.name.toLowerCase()
        val displayName = messageEvent.user.displayName
        val opponent : String?

        if (words.size == 1) {
            opponent = randomViewerExcept(messageEvent, botUsers.plus(username))
            if (opponent == null) {
                sendMessageToChannel(channelName, "Достойных соперников не обнаружено. Kappa")
                return
            }
        } else {
            opponent = words[1].replaceFirst("^@".toRegex(), "").toLowerCase()
            if (opponent == username) {
                sendMessageToChannel(channelName, "Хорошая попытка, $displayName TehePelo")
                return
            }
            if (!viewerOnlineExcept(messageEvent, opponent, botUsers)) {
                sendMessageToChannel(channelName,"Пользователь $opponent в чате не найден. ¯\\_(ツ)_/¯")
                return
            }
        }

        val winner = listOf(displayName, opponent).shuffled().first()

        val emote = if (winner == displayName) positiveEmotes.shuffled().first() else negativeEmotes.shuffled().first()

        val replies = listOf(
                "За право стать величайшим мастером боевых искусств всех времён, $displayName вызывает на бой $opponent! ʕง•ᴥ•ʔง Побеждает $winner! $emote",
                "$displayName vs $opponent. FIGHT! ʕง•ᴥ•ʔง $winner wins! Flawless victory! $emote",
                "$opponent принимает вызов $displayName! ʕง•ᴥ•ʔง В этот раз победу одерживает $winner! $emote",
                "В решающей битве за Лордерон PurpleStar сошлись прославленные герои - $displayName и $opponent! Победа за $winner! $emote")

        sendMessageToChannel(channelName, replies.shuffled().first())
    }
}