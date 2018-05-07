package com.igorini.togepibot.ext

import java.util.*

/** Contains extension properties and functions for [List] */

fun <T> List<T>.random() = this.toMutableList().apply { Collections.shuffle(this) }.first()
fun <T> List<T>.randomOrNull() = this.toMutableList().apply { Collections.shuffle(this) }.firstOrNull()