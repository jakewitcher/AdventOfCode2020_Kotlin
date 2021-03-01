package day2

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day2Tests {

    @Test
    fun `it should validate password by sled rental policy, 1 char matches making password valid`() {
        val input = "1-3 a: abcde"
        assertTrue(validatePasswordByPolicy(input, ::SledRentalPolicy))
    }

    @Test
    fun `it should validate password by sled rental policy, 3 chars match making password valid`() {
        val input = "1-3 a: abacdae"
        assertTrue(validatePasswordByPolicy(input, ::SledRentalPolicy))
    }

    @Test
    fun `it should validate password by sled rental policy, no chars match making password invalid`() {
        val input = "1-3 b: cdefg"
        assertFalse(validatePasswordByPolicy(input, ::SledRentalPolicy))
    }

    @Test
    fun `it should validate password by sled rental policy, more than 3 chars match making password invalid`() {
        val input = "1-3 b: bbfgbb"
        assertFalse(validatePasswordByPolicy(input, ::SledRentalPolicy))
    }

    @Test
    fun `it should count the number of valid sled rental passwords`() {
        val input = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")
        val count = countPasswordsValidatedBySledRentalPolicy(input)

        assertEquals(2, count)
    }

    @Test
    fun `it should validate password by toboggan rental policy, first position char matches making password valid`() {
        val input = "1-3 a: abcde"
        assertTrue(validatePasswordByPolicy(input, ::TobogganRentalPolicy))
    }

    @Test
    fun `it should validate password by toboggan rental policy, third position char matches making password valid`() {
        val input = "1-3 a: cbade"
        assertTrue(validatePasswordByPolicy(input, ::TobogganRentalPolicy))
    }

    @Test
    fun `it should validate password by toboggan rental policy, first and third chars match making password invalid`() {
        val input = "1-3 a: abade"
        assertFalse(validatePasswordByPolicy(input, ::TobogganRentalPolicy))
    }

    @Test
    fun `it should validate password by toboggan rental policy, neither chars match making password invalid`() {
        val input = "1-3 a: ebgde"
        assertFalse(validatePasswordByPolicy(input, ::TobogganRentalPolicy))
    }

    @Test
    fun `it should count the number of valid toboggan rental passwords`() {
        val input = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")
        val count = countPasswordsValidatedByTobogganRentalPolicy(input)

        assertEquals(1, count)
    }
}