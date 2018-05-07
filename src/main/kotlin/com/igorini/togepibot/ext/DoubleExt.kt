package com.igorini.togepibot.ext

/** Contains extension properties and functions for [Double] */
fun Double.roundToInt()= when {
    isNaN() -> throw IllegalArgumentException("Cannot round NaN value.")
    this > Int.MAX_VALUE -> Int.MAX_VALUE
    this < Int.MIN_VALUE -> Int.MIN_VALUE
    else -> Math.round(this).toInt()
}