import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day1Test {
    @Test
    fun `returns top calories`() {
        assertEquals(69281, Day1().exec()[0])
    }

    @Test
    fun `returns top 3 sums`() {
        assertEquals(listOf(69281, 67653, 64590), Day1().exec())
    }
}