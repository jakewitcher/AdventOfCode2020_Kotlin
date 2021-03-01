package day2

import java.io.File

typealias Password = String
typealias PolicyCreator = (Int, Int, Char) -> Policy

interface Policy {
    fun isValidPassword(password: String): Boolean
}

class SledRentalPolicy(private val min: Int, private val max: Int, private val char: Char): Policy {

    override fun isValidPassword(password: String): Boolean {
        val matchingChars = password.filter { it == char }.length

        return matchingChars in min..max
    }
}

class TobogganRentalPolicy(first: Int, second: Int, private val char: Char): Policy {
    private val first = first - 1
    private val second = second - 1

    override fun isValidPassword(password: String): Boolean {
        val isMatchFirst = password.length >= first && password[first] == char
        val isMatchSecond = password.length >= second && password[second] == char

        return isMatchFirst xor isMatchSecond
    }
}

fun countPasswordsValidatedBySledRentalPolicy(input: List<String>): Int {
    return input.fold(0, { acc, ele ->
        if (validatePasswordByPolicy(ele, ::SledRentalPolicy)) acc+1 else acc  })
}

fun countPasswordsValidatedByTobogganRentalPolicy(input: List<String>): Int {
    return input.fold(0, { acc, ele ->
        if (validatePasswordByPolicy(ele, ::TobogganRentalPolicy)) acc+1 else acc  })
}

fun validatePasswordByPolicy(input: String, policyCreator: PolicyCreator): Boolean {
    val (policy, password) = parsePolicyAndPassword(input, policyCreator)
    return policy.isValidPassword(password)
}

val regex = """(\d+)|(\w+)""".toRegex()

fun parsePolicyAndPassword(input: String, policyCreator: PolicyCreator): Pair<Policy, Password> {
    val matchResults = regex.findAll(input)
        .toList().map { it.value }

    if (matchResults.count() != 4) {
        throw IllegalArgumentException()
    }

    val firstNum = matchResults[0].toIntOrNull() ?: throw IllegalArgumentException()
    val secondNum = matchResults[1].toIntOrNull() ?: throw IllegalArgumentException()
    val char = matchResults[2].firstOrNull() ?: throw IllegalArgumentException()

    val password = matchResults[3]
    val policy = policyCreator(firstNum, secondNum, char)

    return Pair(policy, password)
}

fun readInputFile(): List<String> {
    val inputStream = File("./src/main/kotlin/day2/input.txt").inputStream()
    val lines = mutableListOf<String>()

    inputStream.bufferedReader().forEachLine { lines.add(it) }

    return lines
}