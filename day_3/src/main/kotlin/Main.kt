class Main {
    fun exec(): Int {
        val input = this::class.java.getResource("input.txt").readText()

        val parsedInput = input.split("\n")

//        input.split("\n").map {  }
        val lookup = mapOf(
            'a' to 1,
            'b' to 2,
            'c' to 3,
            'd' to 4,
            'e' to 5,
            'f' to 6,
            'g' to 7,
            'h' to 8,
            'i' to 9,
            'j' to 10,
            'k' to 11,
            'l' to 12,
            'm' to 13,
            'n' to 14,
            'o' to 15,
            'p' to 16,
            'q' to 17,
            'r' to 18,
            's' to 19,
            't' to 20,
            'u' to 21,
            'v' to 22,
            'w' to 23,
            'x' to 24,
            'y' to 25,
            'z' to 26,
            'A' to 27,
            'B' to 28,
            'C' to 29,
            'D' to 30,
            'E' to 31,
            'F' to 32,
            'G' to 33,
            'H' to 34,
            'I' to 35,
            'J' to 36,
            'K' to 37,
            'L' to 38,
            'M' to 39,
            'N' to 40,
            'O' to 41,
            'P' to 42,
            'Q' to 43,
            'R' to 44,
            'S' to 45,
            'T' to 46,
            'U' to 47,
            'V' to 48,
            'W' to 49,
            'X' to 50,
            'Y' to 51,
            'Z' to 52,
        )
        val sums = mutableListOf<Int>()
        for (i in parsedInput) {
            var halt = false
            var j = 0
            while (j < i.length.div(2) && !halt) {
                var k = i.length.div(2)
                while (k < i.length) {
                    if (i[j] == i[k]) {
                        println("comparing ${i[j]} at $j and ${i[k]} at $k")
                        println("adding ${i[j]} for $i which is ${lookup[i[j]]}")
                        sums.add(lookup[i[j]]!!)
                        halt = true
                        break
                    }
                    k++
                }
                j++
            }
        }

        return sums.sum()
    }
}

fun main() {
    println(Main().exec())
}