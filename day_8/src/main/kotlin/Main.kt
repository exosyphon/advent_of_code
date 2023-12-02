class Main {
    private val forest = mutableListOf(mutableListOf<Tree>())

    fun part1(): Int {
        val input = this::class.java.getResource("input.txt").readText().trim().split("\n")

        buildForest(input)
        setVisibility()

        return countVisibleTrees()
    }

    fun part2(): Int {
        val input = this::class.java.getResource("input.txt").readText().trim().split("\n")

        buildForest(input)
        setDistance()

        return findMax()
    }

    private fun findMax(): Int {
        var max = 0
        var i = 0
        while (i < forest.size) {
            var j = 0
            while (j < forest[i].size) {
                if (forest[i][j].totalDistance > max) {
                    max = forest[i][j].totalDistance
                }
                j++
            }
            i++
        }
        return max
    }

    private fun setVisibility() {
        var i = 1
        while (i < forest.size - 1) {
            var j = 1
            while (j < forest[i].size - 1) {
                val rowVisibility =
                    checkLeftRowVisibility(i, j, forest[i][j]) || checkRightRowVisibility(i, j, forest[i][j])
                val colVisibility =
                    checkTopColVisibility(i, j, forest[i][j]) || checkBottomColVisibility(i, j, forest[i][j])
                if (rowVisibility || colVisibility) {
                    j++
                    continue
                } else {
                    forest[i][j].visible = false
                    j++
                }
            }
            i++
        }
    }

    private fun setDistance() {
        var i = 1
        while (i < forest.size - 1) {
            var j = 1
            while (j < forest[i].size - 1) {
                val leftDistance = checkLeftRowDistance(i, j, forest[i][j])
                val rightDistance = checkRightRowDistance(i, j, forest[i][j])
                val topDistance = checkTopColDistance(i, j, forest[i][j])
                val bottomDistance = checkBottomColDistance(i, j, forest[i][j])
                forest[i][j].totalDistance = leftDistance * rightDistance * topDistance * bottomDistance
                j++
            }
            i++
        }
    }

    private fun buildForest(input: List<String>) {
        for ((rowIndex, row) in input.withIndex()) {
            if (rowIndex != 0) {
                forest.add(mutableListOf())
            }
            for ((colIndex, column) in row.toCharArray().withIndex()) {
                if (colIndex == 0) {
                    forest[rowIndex] = mutableListOf()
                }
                forest[rowIndex].add(Tree(column.digitToInt(), true, 0))
            }
        }
    }

    private fun checkRightRowDistance(row: Int, col: Int, tree: Tree): Int {
        var result = 0
        var j = col + 1
        while (j < forest[row].size) {
            result += 1
            if (forest[row][j].height >= tree.height) {
                break
            }
            j++
        }
        return result
    }

    private fun checkLeftRowDistance(row: Int, col: Int, tree: Tree): Int {
        var result = 0
        var j = col - 1
        while (j >= 0) {
            result += 1
            if (forest[row][j].height >= tree.height) {
                break
            }
            j--
        }
        return result
    }

    private fun checkBottomColDistance(row: Int, col: Int, tree: Tree): Int {
        var result = 0
        var j = row + 1
        while (j < forest.size) {
            result += 1
            if (forest[j][col].height >= tree.height) {
                break
            }
            j++
        }
        return result
    }

    private fun checkTopColDistance(row: Int, col: Int, tree: Tree): Int {
        var result = 0
        var j = row - 1
        while (j >= 0) {
            result += 1
            if (forest[j][col].height >= tree.height) {
                break
            }
            j--
        }
        return result
    }

    private fun checkLeftRowVisibility(row: Int, col: Int, tree: Tree): Boolean {
        var result = true
        var j = 0
        while (j < forest[row].size) {
            if (j == col) {
                break
            }
            if (forest[row][j].height >= tree.height) {
                result = false
                break
            }
            j++
        }
        return result
    }

    private fun checkRightRowVisibility(row: Int, col: Int, tree: Tree): Boolean {
        var result = true
        var j = forest[row].size - 1
        while (j > 0) {
            if (j == col) {
                break
            }
            if (forest[row][j].height >= tree.height) {
                result = false
                break
            }
            j--
        }
        return result
    }

    private fun checkTopColVisibility(row: Int, col: Int, tree: Tree): Boolean {
        var result = true
        var j = 0
        while (j < forest.size) {
            if (j == row) {
                break
            }
            if (forest[j][col].height >= tree.height) {
                result = false
                break
            }
            j++
        }
        return result
    }

    private fun checkBottomColVisibility(row: Int, col: Int, tree: Tree): Boolean {
        var result = true
        var j = forest.size - 1
        while (j > 0) {
            if (j == row) {
                break
            }
            if (forest[j][col].height >= tree.height) {
                result = false
                break
            }
            j--
        }
        return result
    }

    private fun countVisibleTrees(): Int {
        var result = 0
        var i = 0
        while (i < forest.size) {
            var j = 0
            while (j < forest[i].size) {
                if (forest[i][j].visible) {
                    result += 1
                }
                j++
            }
            i++
        }
        return result
    }
}

data class Tree(val height: Int, var visible: Boolean, var totalDistance: Int)

fun main() {
    println(Main().part1())
    println(Main().part2())
}