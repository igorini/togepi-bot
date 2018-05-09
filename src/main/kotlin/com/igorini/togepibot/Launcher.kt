package com.igorini.togepibot

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.Logger
import com.igorini.togepibot.gui.TogepiApp
import org.koin.dsl.module.applicationContext
import org.koin.standalone.StandAloneContext.startKoin
import tornadofx.*
import org.slf4j.LoggerFactory

val TogepiBotModule = applicationContext {
    bean { TogepiBot() }
}

fun main(args : Array<String>) {
    startKoin(listOf(TogepiBotModule))
    (LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME) as Logger).setLevel(Level.INFO)
    Application()
    launch<TogepiApp>(args)
}