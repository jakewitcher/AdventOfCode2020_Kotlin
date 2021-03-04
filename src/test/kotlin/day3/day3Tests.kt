package day3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day3Tests {
    private val forrestMap = listOf(
        "..##.......",
        "#...#...#..",
        ".#....#..#.",
        "..#.#...#.#",
        ".#...##..#.",
        "..#.##.....",
        ".#.#.#....#",
        ".#........#",
        "#.##...#...",
        "#...##....#",
        ".#..#...#.#"
    )

    @Test
    fun `it should count 3 trees along route for slope of 1 down, 3 right`() {
        val forrestMap = listOf(
            ".....",
            "...#.",
            ".#...",
            "....#"
        )
        val slope = Slope(1, 3)
        val count = countTreesAlongRoute(forrestMap, slope)

        assertEquals(3, count)
    }

    @Test
    fun `it should count 2 trees along route for slope of 1 down, 3 right`() {
        val forrestMap = listOf(
            ".....",
            "...#.",
            ".....",
            "....#"
        )
        val slope = Slope(1, 3)
        val count = countTreesAlongRoute(forrestMap, slope)

        assertEquals(2, count)
    }

    @Test
    fun `it should count N trees along route for the given slope`() {
        val slope = Slope(1, 3)
        val count = countTreesAlongRoute(forrestMap, slope)

        assertEquals(7, count)
    }

    @Test
    fun `it should count 2 trees along route for slope of 1 down, 1 right`() {
        val slope = Slope(1, 1)
        val count = countTreesAlongRoute(forrestMap, slope)

        assertEquals(2, count)
    }

    @Test
    fun `it should count 3 trees along route for slope of 1 down, 5 right`() {
        val slope = Slope(1, 5)
        val count = countTreesAlongRoute(forrestMap, slope)

        assertEquals(3, count)
    }

    @Test
    fun `it should count 4 trees along route for slope of 1 down, 7 right`() {
        val slope = Slope(1, 7)
        val count = countTreesAlongRoute(forrestMap, slope)

        assertEquals(4, count)
    }

    @Test
    fun `it should count 2 trees along route for slope of 2 down, 1 right`() {
        val slope = Slope(2, 1)
        val count = countTreesAlongRoute(forrestMap, slope)

        assertEquals(2, count)
    }
}