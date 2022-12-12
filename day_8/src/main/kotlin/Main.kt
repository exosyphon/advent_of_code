class Main {
    private val forest = mutableListOf(mutableListOf<Tree>())

    fun part1(): Int {
        val input = this::class.java.getResource("input.txt").readText().trim().split("\n")

        for ((rowIndex, row) in input.withIndex()) {
            if (rowIndex != 0) {
                forest.add(mutableListOf())
            }
            for ((colIndex, column) in row.toCharArray().withIndex()) {
                if (colIndex == 0) {
                    forest[rowIndex] = mutableListOf()
                }
                forest[rowIndex].add(Tree(column.digitToInt(), true))
            }
        }

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
        for (f in forest) {
            println(f)
        }

        return countVisibleTrees()
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

data class Tree(val height: Int, var visible: Boolean)

fun main() {
    println(Main().part1())
}