package com.igorini.togepibot

import com.igorini.kotlintwitchbot.TwitchBot
import com.igorini.togepibot.commands.general.duel.Duel
import com.igorini.togepibot.commands.general.duel.Hp
import com.igorini.togepibot.commands.general.duel.top.*
import com.igorini.togepibot.model.Channels
import com.igorini.togepibot.model.DuelTops
import com.igorini.togepibot.model.Duelists
import com.igorini.togepibot.model.Users
import com.igorini.togepibot.properties.DatabaseProperties
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.standalone.KoinComponent
import org.koin.standalone.getProperty

/** Represents a twitch bot */
class TogepiBot : TwitchBot(), KoinComponent {
    init {
        // TODO: In kotlin-twitch-bot make a vararg function registerCommands
        registerCommand(Duel())
        registerCommand(Tops())
        registerCommand(TopWinrate())
        registerCommand(TopHp())
        registerCommand(TopDamage())
        registerCommand(TopDeaths())
        registerCommand(TopDuels())
        registerCommand(TopKills())
        registerCommand(TopMaxHp())
        registerCommand(TopResurrects())
        registerCommand(Hp())
    }

    fun initDatabase() {
        Database.connect(getProperty(DatabaseProperties.url), driver = getProperty(DatabaseProperties.driver), user = getProperty(DatabaseProperties.username), password = getProperty(DatabaseProperties.password))
        transaction {
            create(Channels, Users, Duelists, DuelTops)
        }
    }

    companion object {
        const val togepiBotAdmin = "igor_dmitrievich"
        @JvmField val botUsers = listOf("moobot", "nightbot", "mirrobot", "togepibot", "hereforde", "gamecastlebot")
        @JvmField val positiveEmotes = listOf("VoHiYo", "BloodTrail", "PogChamp", "CoolCat", "SeemsGood", "TehePelo")
        @JvmField val negativeEmotes = listOf("BibleThump", "FailFish", "r6rekt", "DarkMode", "NotLikeThis", "BabyRage", "SwiftRage")
        @JvmField val percents = (1..100).toList()
    }
}