class Main(val debug: Boolean = false) {
    private var head = Position(0, 0)
    private var tail = Position(0, 0)
    private var tails = mutableListOf(
        Position(0, 0),
        Position(0, 0),
        Position(0, 0),
        Position(0, 0),
        Position(0, 0),
        Position(0, 0),
        Position(0, 0),
        Position(0, 0),
        Position(0, 0),
    )

    fun part1(): Int {
        val movements = this::class.java.getResource("input.txt").readText().trim().split("\n")

        var lastHead: Position
        var pastTailMovements = mutableSetOf<Position>()

        for (movement in movements) {
            val split = movement.split(" ")
            val direction = split[0].trim()
            val numberOfMoves = split[1].trim().toInt()

            if (debug) println("== $movement ==")
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
                    if (!checkTouchingHorizontalOrVertical(head, tail)) {
                        if (debug) println("not touching anymore")
                        tail = moveTailUpOrDown(head, tail)
                    }
                } else {
                    if (!checkTouchingDiagonally(head, tail)) {
                        if (debug) println("not touching diagonally even")
                        tail = moveTailDiagonally(head, tail, lastHead)
                    }
                }
                if (debug) println("head: $head")
                if (debug) println("tail: $tail")
                if (debug) println("-----------------------------")

                pastTailMovements.add(tail)
            }
        }

        return pastTailMovements.size
    }

    fun part2(): Int {
        head = Position(0, 0)
        var lastHead: Position
        val movements = this::class.java.getResource("input.txt").readText().trim().split("\n")

        var pastTailMovements = mutableSetOf<Position>()

        for (movement in movements) {
            val split = movement.split(" ")
            val direction = split[0].trim()
            val numberOfMoves = split[1].trim().toInt()

            if (debug) println("== $movement ==")
            var newTails = mutableListOf(
                Position(0, 0),
                Position(0, 0),
                Position(0, 0),
                Position(0, 0),
                Position(0, 0),
                Position(0, 0),
                Position(0, 0),
                Position(0, 0),
                Position(0, 0),
            )
            repeat(numberOfMoves) {
                if (debug) println("--- another move ---")
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
                var tempHead = head
                if (debug) println("head: $head")
                for ((index, tail) in tails.withIndex()) {
                    var temp = tail
                    if (tail.x == tempHead.x || tail.y == tempHead.y) {
                        if (!checkTouchingHorizontalOrVertical(tempHead, tail)) {
                            if (debug) println("not touching anymore")
                            temp = moveTailUpOrDown(tempHead, tail)
                        }
                    } else {
                        if (!checkTouchingDiagonally(tempHead, tail)) {
                            if (debug) println("not touching diagonally even")
                            temp = moveTailDiagonally(tempHead, tail, lastHead)
                        }
                    }
                    if (debug) println("$index $temp")

                    tempHead = temp
                    lastHead = tail
                    newTails[index] = temp
                    if (index == tails.size - 1) {
                        if (debug) println("adding $temp as past tail movement")
                        pastTailMovements.add(temp)
                    }
                }
                tails = newTails
            }
        }

        return pastTailMovements.size
    }

    private fun moveTailDiagonally(head: Position, tail: Position, lastHead: Position): Position {
        if (checkTouchingHorizontal(head, Position(tail.x - 1, tail.y + 1))) {
            return Position(tail.x - 1, tail.y + 1)
        }
        if (checkTouchingVertical(head, Position(tail.x - 1, tail.y + 1))) {
            return Position(tail.x - 1, tail.y + 1)
        }

        if (checkTouchingHorizontal(head, Position(tail.x + 1, tail.y - 1))) {
            return Position(tail.x + 1, tail.y - 1)
        }
        if (checkTouchingVertical(head, Position(tail.x + 1, tail.y - 1))) {
            return Position(tail.x + 1, tail.y - 1)
        }

        if (checkTouchingHorizontal(head, Position(tail.x - 1, tail.y - 1))) {
            return Position(tail.x - 1, tail.y - 1)
        }
        if (checkTouchingVertical(head, Position(tail.x - 1, tail.y - 1))) {
            return Position(tail.x - 1, tail.y - 1)
        }

        if (checkTouchingHorizontal(head, Position(tail.x + 1, tail.y + 1))) {
            return Position(tail.x + 1, tail.y + 1)
        }
        if (checkTouchingVertical(head, Position(tail.x + 1, tail.y + 1))) {
            return Position(tail.x + 1, tail.y + 1)
        }

        if (head.y > tail.y && head.x > tail.x) {
            return Position(lastHead.x, lastHead.y)
        }

        if (head.y < tail.y && head.x < tail.x) {
            return Position(lastHead.x, lastHead.y)
        }

        if (head.y > tail.y && head.x < tail.x) {
            return Position(lastHead.x, lastHead.y)
        }

        if (head.y < tail.y && head.x > tail.x) {
            return Position(lastHead.x, lastHead.y)
        }
        return tail
    }

    private fun moveTailUpOrDown(head: Position, tail: Position): Position {
        if (tail.x == head.x && tail.y - 2 == head.y) {
            return Position(tail.x, tail.y - 1)
        }
        if (tail.x == head.x && tail.y + 2 == head.y) {
            return Position(tail.x, tail.y + 1)
        }
        if (tail.y == head.y && tail.x + 2 == head.x) {
            return Position(tail.x + 1, tail.y)
        }
        if (tail.y == head.y && tail.x - 2 == head.x) {
            return Position(tail.x - 1, tail.y)
        }
        return tail
    }

    private fun checkTouchingHorizontalOrVertical(head: Position, tail: Position): Boolean {
        if (checkTouchingHorizontal(head, tail)) {
            return true
        }
        if (checkTouchingVertical(head, tail)) {
            return true
        }
        if (tail.y == head.y && tail.x == head.x) {
            return true
        }
        return false
    }

    private fun checkTouchingHorizontal(head: Position, tail: Position): Boolean =
        tail.x == head.x && (tail.y == head.y + 1 || tail.y == head.y - 1)

    private fun checkTouchingVertical(head: Position, tail: Position): Boolean =
        tail.y == head.y && (tail.x == head.x + 1 || tail.x == head.x - 1)

    private fun checkTouchingDiagonally(head: Position, tail: Position): Boolean {
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
    println("Part 1: ${Main().part1()}")
    println("Part 2: ${Main().part2()}")
}

