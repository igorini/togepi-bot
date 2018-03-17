package com.igorini.togepibot

import org.koin.dsl.module.applicationContext
import org.koin.standalone.StandAloneContext.startKoin

val TogepiBotModule = applicationContext {
    bean { TogepiBot() }
}

fun main(args : Array<String>) {
    startKoin(listOf(TogepiBotModule))
    Application()
}