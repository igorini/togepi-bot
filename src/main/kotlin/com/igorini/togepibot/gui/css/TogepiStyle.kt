package com.igorini.togepibot.gui.css

import tornadofx.*

/** Represents */
class TogepiStyle: Stylesheet() {
    companion object {
        val speechToImageView by cssclass()

        val greenColor = c("#00b140")
    }

    init {
        select(speechToImageView) {
            backgroundColor += greenColor
        }
    }
}