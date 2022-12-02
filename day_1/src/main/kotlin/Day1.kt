class Day1 {
    fun exec(): List<Int> {
        val input = this::class.java.getResource("input.txt").readText()

        return input.split("\n\n").map { line ->
            line.split("\n").filter { it != "" }.sumOf { it.toInt() }
        }.sortedDescending().slice(0..2)
    }
}

fun main(args: Array<String>) {
    println(Day1().exec())
}
