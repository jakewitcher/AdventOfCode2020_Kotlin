import day1.findProductOfThreeExpenseReportEntriesEqualTo2020
import day1.findProductOfTwoExpenseReportEntriesEqualTo2020

fun main(args: Array<String>) {
    val product = findProductOfThreeExpenseReportEntriesEqualTo2020()

    if (product == null) {
        print("no product found")
        return
    }

    println("product of two numbers with sum of 2020 is $product")
}