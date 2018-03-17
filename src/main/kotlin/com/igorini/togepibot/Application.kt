package com.igorini.togepibot

import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

/** Represents a Togepi Bot application */
class Application : KoinComponent {

    private val togepiBot: TogepiBot by inject()

    init {
        togepiBot.initDatabase()
        togepiBot.start()
    }
}