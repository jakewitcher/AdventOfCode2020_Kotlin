package day1

import java.io.File

fun findProductOfTwoExpenseReportEntriesEqualTo(target: Int, expenses: List<Int>): Int? {
    val foundExpenses = findTwoEntriesWithSumEqualTo(target, expenses) ?: return null
    return foundExpenses.first * foundExpenses.second
}

fun findProductOfThreeExpenseReportEntriesEqualTo(target: Int, expenses: List<Int>): Int? {
    val foundExpenses = findThreeEntriesWithSumEqualTo(target, expenses) ?: return null
    return foundExpenses.first * foundExpenses.second * foundExpenses.third
}

fun findTwoEntriesWithSumEqualTo(target: Int, entries: List<Int>): Pair<Int, Int>? {
    return entries
        .flatMapIndexed { i, entry1 -> entries.subList(i + 1, entries.size).mapIndexed { j, entry2 ->
            if (i == j) null else Pair(entry1, entry2) } }
        .dropWhile { it == null || it.first + it.second != target }
        .firstOrNull()
}

fun findThreeEntriesWithSumEqualTo(target: Int, entries: List<Int>): Triple<Int, Int, Int>? {
    return entries
        .flatMapIndexed { i, entry1, ->
            entries.subList(i + 1, entries.size).flatMapIndexed { j, entry2 ->
                entries.subList(j + 1, entries.size).mapIndexed { k, entry3 ->
            if (i == j || j == k || i == k) null else Triple(entry1, entry2, entry3) } } }
        .dropWhile { it == null || it.first + it.second + it.third != target }
        .firstOrNull()
}

fun readInputFile(): List<Int> {
    val inputStream = File("./src/main/kotlin/day1/input.txt").inputStream()
    val lines = mutableListOf<Int>()

    inputStream.bufferedReader().forEachLine { lines.add(it.toInt()) }

    return lines
}