class Day2 {
    fun exec(): Int {
        val input = this::class.java.getResource("input.txt").readText()

        val win = 6
        val loss = 0
        val tie = 3

        val values = mapOf(
            "X" to 1,
            "Y" to 2,
            "Z" to 3
        )

        // A rock
        // B paper
        // C scissors
        // X rock
        // Y paper
        // Z scissors

        // X lose
        // Y tie
        // Z win

        return input.split("\n").mapNotNull { outer ->
            val items = outer.split(" ")
            if (items[0] == "A" && items[1] == "Y") {
                tie + values["X"]!!
            } else if (items[0] == "A" && items[1] == "Z") {
                win + values["Y"]!!
            } else if (items[0] == "A" && items[1] == "X") {
                loss + values["Z"]!!
            } else if (items[0] == "B" && items[1] == "X") {
                loss + values["X"]!!
            } else if (items[0] == "B" && items[1] == "Y") {
                tie + values["Y"]!!
            } else if (items[0] == "B" && items[1] == "Z") {
                win + values["Z"]!!
            } else if (items[0] == "C" && items[1] == "X") {
                loss + values["Y"]!!
            } else if (items[0] == "C" && items[1] == "Y") {
                tie + values["Z"]!!
            } else if (items[0] == "C" && items[1] == "Z") {
                win + values["X"]!!
            } else {
                0
            }
        }.sum()
    }
}

fun main(args: Array<String>) {
    println(Day2().exec())
}
