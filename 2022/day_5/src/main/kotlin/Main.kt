class Main {
    fun part1(): String {
        val input = this::class.java.getResource("input.txt").readText()
            .split("\n\n")

        val stacks = parseHeader(input[0].split("\n"))
        printTheStack(stacks)
        parseMoves(input, stacks)

        return output(stacks)
    }

    fun part2(): String {
        val input = this::class.java.getResource("input.txt").readText()
            .split("\n\n")

        val stacks = parseHeader(input[0].split("\n"))
        printTheStack(stacks)
        parseMovesWithBlocks(input, stacks)

        return output(stacks)
    }

    private fun parseMovesWithBlocks(
        input: List<String>,
        stacks: List<ArrayDeque<String>>
    ) {
        for (move in input[1].split("\n")) {
            val moveParts = move.split("from")
            val stacksToMove = moveParts[0].trim().split(" ")[1].toInt()
            val stackSplit = moveParts[1].split("to")
            val stackLogic = mapOf(
                stackSplit[0].trim().last().digitToInt() to stackSplit[1].trim().last().digitToInt()
            )
            println(move)
            moveStacksWithBlocks(stacksToMove, stackLogic, stacks)
            printTheStack(stacks)
        }
    }

    private fun parseMoves(
        input: List<String>,
        stacks: List<ArrayDeque<String>>
    ) {
        for (move in input[1].split("\n")) {
            val moveParts = move.split("from")
            val stacksToMove = moveParts[0].trim().split(" ")[1].toInt()
            val stackSplit = moveParts[1].split("to")
            val stackLogic = mapOf(
                stackSplit[0].trim().last().digitToInt() to stackSplit[1].trim().last().digitToInt()
            )
            println(move)
            moveStacks(stacksToMove, stackLogic, stacks)
            printTheStack(stacks)
        }
    }

    private fun output(stacks: List<ArrayDeque<String>>): String {
        var result = ""
        for (stack in stacks) {
            result += stack.last()
        }
        return result
    }

    private fun moveStacks(stacksToMove: Int, stackLogic: Map<Int, Int>, stacks: List<ArrayDeque<String>>) {
        repeat(stacksToMove) {
            stacks[stackLogic.values.first() - 1].addLast(
                stacks[stackLogic.keys.first() - 1].removeLast()
            )
        }
    }

    private fun moveStacksWithBlocks(stacksToMove: Int, stackLogic: Map<Int, Int>, stacks: List<ArrayDeque<String>>) {
        var temp = ArrayDeque<String>()
        repeat(stacksToMove) {
            temp.addFirst(
                stacks[stackLogic.keys.first() - 1].removeLast()
            )
        }
        for(character in temp) {
            stacks[stackLogic.values.first() - 1].addLast(character)
        }
    }

    private fun printTheStack(header: List<List<String>>) {
        for ((index, i) in header.withIndex()) {
            println("${index + 1} $i")
        }
        println("----------------------------")
    }

    private fun parseHeader(input: List<String>): List<ArrayDeque<String>> {
        val temp = mutableListOf<ArrayDeque<String>>()
        val numOfStacks = input.last().last().digitToInt()
        repeat(numOfStacks) {
            temp.add(ArrayDeque())
        }

        for (line in input) {
            var i = 1
            var stack = 0
            while (i < line.length) {
                if (line[i] == null) {
                    break
                }
                val character = line[i]
                if (character.code in 65..90) {
                    temp[stack].addFirst(character.toString())
                }
                i += 4
                stack++
            }
        }
        return temp
    }
}

fun main() {
    println("output: ${Main().part1()}")
    println("output: ${Main().part2()}")
}