class Main {
    fun part1(): Int {
        val input = this::class.java.getResource("input.txt").readText()

        var marker = 0
        var tracker = ArrayDeque<Char>(4)
        for ((index, character) in input.withIndex()) {
            if (index > 3) {
                if (tracker.distinct().size == 4) {
                    marker = index
                    break
                }
                tracker.removeFirst()
            }

            tracker.addLast(character)
        }

        return marker
    }

    fun part2(): Int {
        val input = this::class.java.getResource("input.txt").readText()

        var marker = 0
        var tracker = ArrayDeque<Char>(14)
        for ((index, character) in input.withIndex()) {
            if (index > 13) {
                if (tracker.distinct().size == 14) {
                    marker = index
                    break
                }
                tracker.removeFirst()
            }

            tracker.addLast(character)
        }

        return marker
    }
}

fun main() {
    println(Main().part1())
    println(Main().part2())
}
