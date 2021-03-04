import day1.findProductOfThreeExpenseReportEntriesEqualTo
import day1.findProductOfTwoExpenseReportEntriesEqualTo
import day2.countPasswordsValidatedBySledRentalPolicy
import day2.countPasswordsValidatedByTobogganRentalPolicy
import day3.Slope
import day3.countTreesAlongRoute

fun main(args: Array<String>) {
    day3Part1()
    day3Part2()
}

fun day1Part1() {
    val product = findProductOfTwoExpenseReportEntriesEqualTo(2020, day1.readInputFile())
    println("product of 2 expense report entries equal to 2020: $product")
}

fun day1Part2() {
    val product = findProductOfThreeExpenseReportEntriesEqualTo(2020, day1.readInputFile())
    println("product of 3 expense report entries equal to 2020: $product")
}

fun day2Part1() {
    val count = countPasswordsValidatedBySledRentalPolicy(day2.readInputFile())
    println("valid sled rental passwords: $count")
}

fun day2Part2() {
    val count = countPasswordsValidatedByTobogganRentalPolicy(day2.readInputFile())
    println("valid toboggan rental passwords: $count")
}

fun day3Part1() {
    val count = countTreesAlongRoute(day3.readInputFile(), Slope(1,3))
    println("number of trees along route: $count")
}

fun day3Part2() {
    val slopes = listOf(
        Slope(1,1),
        Slope(1,3),
        Slope(1,5),
        Slope(1, 7),
        Slope(2, 1)
    )

    val input = day3.readInputFile()
    val product = slopes.fold(1L) { acc, slope -> acc * countTreesAlongRoute(input, slope) }
    println("product of trees along route for all slopes: $product")
}