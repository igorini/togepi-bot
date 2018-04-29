package com.igorini.togepibot.ext

import org.joda.time.Period

/** Contains extension properties and functions for [Period]  */

/** Russian display value */
fun Period.displayRus() = "${if (minutes > 0) minutes.toString() + " мин " else ""}$seconds сек"