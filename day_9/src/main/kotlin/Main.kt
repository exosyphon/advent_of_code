class Main {
    private var head = Position(0, 0)
    private var lastHead = Position(0, 0)
    private var tail = Position(0, 0)

    fun part1(): Int {
        val movements = this::class.java.getResource("input.txt").readText().trim().split("\n")

        var pastTailMovements = mutableSetOf<Position>()

        for (movement in movements) {
            val split = movement.split(" ")
            val direction = split[0].trim()
            val numberOfMoves = split[1].trim().toInt()

            println("== $movement ==")
            repeat(numberOfMoves) {
                lastHead = head
                when (direction) {
                    "R" -> {
                        head = Position(head.x + 1, head.y)
                    }

                    "U" -> {
                        head = Position(head.x, head.y + 1)
                    }

                    "L" -> {
                        head = Position(head.x - 1, head.y)
                    }

                    "D" -> {
                        head = Position(head.x, head.y - 1)
                    }
                }
                if (tail.x == head.x || tail.y == head.y) {
                    if (!checkTouchingHorizontalOrVertical()) {
                        println("not touching anymore")
                        moveTailUpOrDown()
                    }
                } else {
                    if (!checkTouchingDiagonally()) {
                        println("not touching diagonally even")
                        moveTailDiagonally()
                    }
                }
                println("head: $head")
                println("tail: $tail")
                println("-----------------------------")

                pastTailMovements.add(tail)
            }
        }

        return pastTailMovements.size
    }

    private fun moveTailDiagonally() {
        if (head.y > tail.y && head.x > tail.x) {
            tail = Position(lastHead.x, lastHead.y)
        }

        if (head.y < tail.y && head.x < tail.x) {
            tail = Position(lastHead.x, lastHead.y)
        }

        if (head.y > tail.y && head.x < tail.x) {
            tail = Position(lastHead.x, lastHead.y)
        }

        if (head.y < tail.y && head.x > tail.x) {
            tail = Position(lastHead.x, lastHead.y)
        }
    }

    private fun moveTailUpOrDown() {
        if (tail.x == head.x && tail.y - 2 == head.y) {
            tail = Position(tail.x, tail.y - 1)
        }
        if (tail.x == head.x && tail.y + 2 == head.y) {
            tail = Position(tail.x, tail.y + 1)
        }
        if (tail.y == head.y && tail.x + 2 == head.x) {
            tail = Position(tail.x + 1, tail.y)
        }
        if (tail.y == head.y && tail.x - 2 == head.x) {
            tail = Position(tail.x - 1, tail.y)
        }
    }

    private fun checkTouchingHorizontalOrVertical(): Boolean {
        if (tail.x == head.x && (tail.y == head.y + 1 || tail.y == head.y - 1)) {
            return true
        }
        if (tail.y == head.y && (tail.x == head.x + 1 || tail.x == head.x - 1)) {
            return true
        }
        return false
    }

    private fun checkTouchingDiagonally(): Boolean {
        if (tail.y - 1 == head.y && tail.x - 1 == head.x) {
            return true
        }
        if (tail.y + 1 == head.y && tail.x + 1 == head.x) {
            return true
        }
        if (head.y - 1 == tail.y && head.x - 1 == tail.x) {
            return true
        }
        if (head.y + 1 == tail.y && head.x + 1 == tail.x) {
            return true
        }
        if (head.y - 1 == tail.y && head.x + 1 == tail.x) {
            return true
        }
        if (head.y + 1 == tail.y && head.x - 1 == tail.x) {
            return true
        }
        if (head.y == tail.y - 1 && head.x == tail.x + 1) {
            return true
        }
        if (head.y == tail.y + 1 && head.x == tail.x - 1) {
            return true
        }
        return false
    }
}

data class Position(val x: Int, val y: Int)

fun main() {
    println(Main().part1())
}

