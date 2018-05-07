package com.igorini.togepibot

import com.igorini.togepibot.gui.TogepiApp
import org.koin.dsl.module.applicationContext
import org.koin.standalone.StandAloneContext.startKoin
import tornadofx.*
import java.io.File

val TogepiBotModule = applicationContext {
    bean { TogepiBot() }
}

fun main(args : Array<String>) {
    startKoin(listOf(TogepiBotModule))
    Application()
    launch<TogepiApp>(args)
}