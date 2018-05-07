package com.igorini.togepibot.gui

import com.igorini.togepibot.gui.controllers.TogepiController
import com.igorini.togepibot.gui.css.TogepiStyle
import com.igorini.togepibot.gui.views.TogepiView
import javafx.stage.Stage
import tornadofx.App

/** Represents */
class TogepiApp : App(TogepiView::class, TogepiStyle::class) {
    val togepiController: TogepiController by inject()

    override fun start(stage: Stage) {
        super.start(stage)
        togepiController.init()
    }
}