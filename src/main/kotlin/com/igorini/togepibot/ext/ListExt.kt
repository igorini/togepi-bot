package com.igorini.togepibot.ext

/** Contains extension properties and functions for [List] */

fun <T> List<T>.random() = this.shuffled().first()