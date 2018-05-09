package com.igorini.togepibot.ext

import java.util.*

/** Contains extension properties and functions for [List] */

fun <T> List<T>.random() = this.toMutableList().apply { Collections.shuffle(this) }.first()
fun <T> List<T>.randomOrNull() = this.toMutableList().apply { Collections.shuffle(this) }.firstOrNull()

/**
 * Checks if a list of words consecutively contains elements that are part of the text split into words.
 *
 * e.g.
 * ```
 * listOf("good", "morning").containsConsecutive("good morning") -> true
 * listOf("good", "morning").containsConsecutive("good") -> true
 * listOf("good", "early", "morning").containsConsecutive("good morning") -> false
 * ```
 */
fun List<String>.containsConsecutive(textToFind: String): Boolean {
    val wordsToFind = textToFind.toLowerCase().split("\\P{L}+".toRegex())
    if (wordsToFind.size == 1) return contains(wordsToFind.first())

    fun containsTheRest(wordsIndex: Int, wordsToFindIndex: Int): Boolean {
        if (wordsToFindIndex > (wordsToFind.size - 1)) return true
        if (wordsIndex >= this.size) return false

        return (wordsToFind[wordsToFindIndex] == this[wordsIndex]) && containsTheRest(wordsIndex + 1, wordsToFindIndex + 1)
    }

    this.forEachIndexed { index, word -> if (word == wordsToFind.first() && containsTheRest(index + 1, 1)) return true }
    return false
}