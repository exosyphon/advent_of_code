class Main {
    fun exec(): Int {
        val input = this::class.java.getResource("input.txt").readText().split("\n")

        var acc = 0
        for ((index, line) in input.withIndex()) {
            val values = line.split(",").flatMap { it.split("-") }

            println("${values[0]} ${values[1]} ${values[2]} ${values[3]} ")
            if ((values[0].toInt() <= values[2].toInt() && values[1].toInt() >= values[3].toInt()) ||
                (values[0].toInt() >= values[2].toInt() && values[1].toInt() <= values[3].toInt()) ||
                (values[0].toInt() <= values[2].toInt() && values[1].toInt() >= values[2].toInt()) ||
                (values[0].toInt() >= values[2].toInt() && values[1].toInt() >= values[3].toInt() && values[0].toInt() <= values[3].toInt())) {
                println("count it! $index")
                acc += 1
            }
        }

        return acc
    }
}

fun main() {
    println(Main().exec())
}