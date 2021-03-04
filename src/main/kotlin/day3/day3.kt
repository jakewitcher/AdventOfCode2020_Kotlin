package day3

import java.io.File

data class Slope(val down: Int, val right: Int)
data class Position(val row: Int, val column: Int)

fun countTreesAlongRoute(forrestMap: List<String>, slope: Slope): Long {
    return forrestMap.foldIndexed(0) { i, acc, row ->
        if (i % slope.down != 0) {
            acc
        } else {
            val multiplier = i / slope.down + 1

            val position = Position(
                getRow(i, slope.down),
                getColumn(slope.right, multiplier, row.length)
            )

            val char = getCharAt(position, forrestMap)

            if (char != null && isTree(char)) acc + 1 else acc
        }
    }
}

fun getRow(start: Int, step: Int) = start + step

fun getColumn(step: Int, multiplier: Int, width: Int) = step * multiplier % width

fun getCharAt(position: Position, forrestMap: List<String>): Char? =
    if (position.row >= forrestMap.size) null else forrestMap[position.row][position.column]

fun isTree(char: Char) = char == '#'

fun readInputFile(): List<String> {
    val inputStream = File("./src/main/kotlin/day3/input.txt").inputStream()
    val lines = mutableListOf<String>()

    inputStream.bufferedReader().forEachLine { lines.add(it) }

    return lines
}