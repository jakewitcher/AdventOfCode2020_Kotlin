import day1.findProductOfThreeExpenseReportEntriesEqualTo
import day1.findProductOfTwoExpenseReportEntriesEqualTo
import day2.countPasswordsValidatedBySledRentalPolicy
import day2.countPasswordsValidatedByTobogganRentalPolicy
import day3.Slope
import day3.countTreesAlongRoute

fun main(args: Array<String>) {
    day3Part1()
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