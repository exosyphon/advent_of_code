class Main {
    fun exec(): Int {
        val input = this::class.java.getResource("input.txt").readText().trim().split("\n")

        var registerX = mutableListOf<Cycle>()
        for ((index, instruction) in input.withIndex()) {
            if (index == 0) {
                if (instruction.startsWith("noop")) {
                    registerX.add(Cycle(1, 1))
                } else {
                    registerX.add(Cycle(1, 1))
                    val incrementAmount = instruction.trim().split(" ")[1].toInt()
                    registerX.add(Cycle(1, 1 + incrementAmount))
                }
            } else {
                if (instruction.startsWith("noop")) {
                    registerX.add(Cycle(registerX[registerX.size - 1].after, registerX[registerX.size - 1].after))
                } else {
                    registerX.add(Cycle(registerX[registerX.size - 1].after, registerX[registerX.size - 1].after))
                    val incrementAmount = instruction.trim().split(" ")[1].toInt()
                    registerX.add(
                        Cycle(
                            registerX[registerX.size - 1].after,
                            registerX[registerX.size - 1].after + incrementAmount
                        )
                    )
                }
            }
        }
//        for ((index, thing) in registerX.withIndex()) {
//            println("$index, $thing")
//        }

        return sumInterestingRegisters(registerX)
    }

    private fun sumInterestingRegisters(registerX: MutableList<Cycle>): Int {
        return (20 * registerX[20 - 1].during) + (60 * registerX[60 - 1].during) + (100 * registerX[100 - 1].during) +
                (140 * registerX[140 - 1].during) + (180 * registerX[180 - 1].during) + (220 * registerX[220 - 1].during)
    }

}

data class Cycle(val during: Int, val after: Int)

fun main() {
    println(Main().exec())
}