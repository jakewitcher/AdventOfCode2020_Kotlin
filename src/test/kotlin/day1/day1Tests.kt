package day1

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class Day1Tests {

    @Test
    fun `it should find two different numbers in list equal to target value`() {
        val numPair = findTwoEntriesWithSumEqualTo(50, listOf(10, 20, 25, 40, 15))
        assertEquals(Pair(10, 40), numPair)
    }

    @Test
    fun `it should find the same number at different indices with sum equal to target`() {
        val numPair = findTwoEntriesWithSumEqualTo(50, listOf(10, 20, 25, 25, 15))
        assertEquals(Pair(25, 25), numPair)
    }

    @Test
    fun `it should return null when no two numbers equal target value`() {
        val numPair = findTwoEntriesWithSumEqualTo(50, listOf(10, 20, 25, 35, 100))
        assertNull(numPair)
    }

    @Test
    fun `it should return 1721 and 299 for provided test case`() {
        val numPair = findTwoEntriesWithSumEqualTo(2020, listOf(1721, 979, 366, 299, 675, 1456))
        assertEquals(Pair(1721, 299), numPair)
    }

    @Test
    fun `it should find three different numbers in list equal to target value`() {
        val numTriple = findThreeEntriesWithSumEqualTo(50, listOf(10, 20, 25, 40, 5))
        assertEquals(Triple(20, 25, 5), numTriple)
    }

    @Test
    fun `it should return null when no three numbers equal target value`() {
        val numTriple = findThreeEntriesWithSumEqualTo(50, listOf(10, 20, 25, 35, 100))
        assertNull(numTriple)
    }

    @Test
    fun `it should return 979, 366, and 675 for provided test case`() {
        val numTriple = findThreeEntriesWithSumEqualTo(2020, listOf(1721, 979, 366, 299, 675, 1456))
        assertEquals(Triple(979, 366, 675), numTriple)
    }
}