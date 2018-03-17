package com.igorini.togepibot

import com.igorini.kotlintwitchbot.TwitchBot
import com.igorini.togepibot.commands.general.Duel
import org.koin.standalone.KoinComponent

/** Represents a twitch bot */
class TogepiBot : TwitchBot(), KoinComponent {
    init {
        registerCommand(Duel())
    }

    companion object {
        @JvmField val botUsers = listOf("moobot", "nighbot", "mirrobot", "togepibot")
        @JvmField val positiveEmotes = listOf("VoHiYo", "BloodTrail", "PogChamp", "CoolCat", "SeemsGood", "TehePelo")
        @JvmField val negativeEmotes = listOf("BibleThump", "FailFish", "r6rekt", "DarkMode", "NotLikeThis", "BabyRage", "SwiftRage")
    }
}
