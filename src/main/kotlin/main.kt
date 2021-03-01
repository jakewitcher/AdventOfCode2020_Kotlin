import day1.findProductOfThreeExpenseReportEntriesEqualTo
import day1.findProductOfTwoExpenseReportEntriesEqualTo
import day2.countPasswordsValidatedBySledRentalPolicy
import day2.countPasswordsValidatedByTobogganRentalPolicy

fun main(args: Array<String>) {
    day2Part1()
    day2Part2()
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