package com.igorini.togepibot

import com.igorini.kotlintwitchbot.TwitchBot
import com.igorini.togepibot.commands.general.duel.Duel
import com.igorini.togepibot.commands.general.duel.Hp
import com.igorini.togepibot.commands.general.duel.spot.black.BlackSpotCommand
import com.igorini.togepibot.commands.general.duel.spot.white.WhiteSpotCommand
import com.igorini.togepibot.commands.general.duel.top.*
import com.igorini.togepibot.listeners.ChannelMessageInterceptor
import com.igorini.togepibot.model.*
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
        registerCommand(TopBounty())
        registerCommand(Hp())
        registerCommand(BlackSpotCommand())
        registerCommand(WhiteSpotCommand())

        registerListener(ChannelMessageInterceptor())
    }

    fun initDatabase() {
        Database.connect(getProperty(DatabaseProperties.url), driver = getProperty(DatabaseProperties.driver), user = getProperty(DatabaseProperties.username), password = getProperty(DatabaseProperties.password))
        transaction {
            create(Channels, Users, Duelists, DuelTops, DuelLeaders, BlackSpots, WhiteSpots)
        }
    }

    companion object {
        const val togepiBotAdmin = "igor_dmitrievich"
        const val guiChannel = "igor_dmitrievich"
        @JvmField val botUsers = listOf("moobot", "nightbot", "mirrobot", "togepibot", "hereforde", "gamecastlebot", "electricallongboard", "electricalskateboard", "wizebot")
        @JvmField val positiveEmotes = listOf("VoHiYo", "BloodTrail", "PogChamp", "CoolCat", "SeemsGood", "TehePelo")
        @JvmField val negativeEmotes = listOf("BibleThump", "FailFish", "DarkMode", "NotLikeThis", "BabyRage", "SwiftRage")
        @JvmField val percents = (1..100).toList()
    }
}