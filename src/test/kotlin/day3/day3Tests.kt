package day3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day3Tests {

    @Test
    fun `it should count 3 trees along route`() {
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
    fun `it should count 2 trees along route`() {
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
    fun `it should count n trees along route`() {
        val forrestMap = listOf(
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
        val slope = Slope(1, 3)
        val count = countTreesAlongRoute(forrestMap, slope)

        assertEquals(7, count)
    }
}