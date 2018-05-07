package com.igorini.togepibot.gui.views

import javafx.geometry.Pos
import tornadofx.*
import javafx.scene.image.ImageView

/** Represents */
class TogepiView : View() {
    lateinit var imageView: ImageView

    companion object {
        @JvmField val prefWidth = 800.0
        @JvmField val prefHeight = 800.0
    }

    override val root = vbox {
        title = "speech-to-image"
        style {
            backgroundColor += c("#00b140")
        }
        setMaxSize(prefWidth, prefHeight)
        setAlignment(Pos.BOTTOM_RIGHT)
        imageView = imageview {
            fitWidth = prefWidth
            fitHeight = prefHeight
        }
    }
}