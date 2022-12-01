class Day1 {
    fun exec(caloriesThreshold: Int): Int{
        val input = this::class.java.getResource("input.txt").readText().split("\n")

        var maxCalories = 0
        var currentCalories = 0
        for (i in input) {
            if (i == "") {
                currentCalories = 0
                continue
            } else {
                currentCalories += i.toInt()
            }
            if (currentCalories > maxCalories && currentCalories < caloriesThreshold) {
                maxCalories = currentCalories
            }
        }

        println("Max calories is: $maxCalories")
        return maxCalories
    }
}
fun main() {
    println(Day1().exec(100_000) + Day1().exec(69281) + Day1().exec(67653))
}
