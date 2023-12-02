import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MainKtTest {
    @Test
    fun `werks sooo goood`() {
        assertEquals("CMZ", Main().part1())
    }
    @Test
    fun `part2`() {
        assertEquals("MCD", Main().part2())
    }
}