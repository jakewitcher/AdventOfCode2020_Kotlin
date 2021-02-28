package day1

import java.io.File

fun findProductOfTwoExpenseReportEntriesEqualTo2020(): Int? {
    val numPair = findTwoEntriesWithSumEqualTo(2020, readInputFile()) ?: return null
    return numPair.first * numPair.second
}

fun findProductOfThreeExpenseReportEntriesEqualTo2020(): Int? {
    val numTriple = findThreeEntriesWithSumEqualTo(2020, readInputFile()) ?: return null
    return numTriple.first * numTriple.second * numTriple.third
}

fun findTwoEntriesWithSumEqualTo(target: Int, entries: List<Int>): Pair<Int, Int>? {
    return entries
        .flatMapIndexed { i, entry1 -> entries.mapIndexed { j, entry2 ->
            if (i == j) null else Pair(entry1, entry2) } }
        .dropWhile { it == null || it.first + it.second != target }
        .firstOrNull()
}

fun findThreeEntriesWithSumEqualTo(target: Int, entries: List<Int>): Triple<Int, Int, Int>? {
    return entries
        .flatMapIndexed { i, entry1, -> entries.flatMapIndexed { j, entry2 -> entries.mapIndexed { k, entry3 ->
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