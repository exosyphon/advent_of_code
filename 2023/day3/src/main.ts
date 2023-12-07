import fs from "fs"

type Position = {
  x: number
  y: number
}

export class Main {
  public readInput(test): string[][] {
    const fileName = test ? "./src/test_input.txt" : "./src/input.txt"
    const allFileContents = fs.readFileSync(fileName, "utf-8")
    const arr: string[][] = []
    allFileContents.split("\n").forEach((line: string, index: number) => {
      if (line.length > 0) {
        arr.push([])
        line.split("").forEach((linePart) => arr[index].push(linePart))
      }
    })
    return arr
  }

  public execute({ test = false, part2 = false } = {}): number {
    const arr = this.readInput(test)
    // arr.forEach((v) => console.log(...v))

    let sum = 0

    for (let i = 0; i < arr.length; i++) {
      let value = ""
      let adjacentSymbol = false
      for (let j = 0; j < arr[i].length; j++) {
        if (arr[i][j].match(/\d/)) {
          if (this.checkAdjacent(arr, { x: i, y: j })) {
            adjacentSymbol = true
          }
          value = value.concat(arr[i][j])

          if (j == arr[i].length - 1) {
            if (adjacentSymbol) {
              sum = sum + Number(value)
            }
          }
        } else {
          if (value.length > 0) {
            if (adjacentSymbol) {
              sum = sum + Number(value)
            }
            value = ""
            adjacentSymbol = false
          }
        }
      }
    }

    return sum
  }

  public checkAdjacent(matrix: string[][], position: Position): boolean {
    const symbolRegex = /[^.\d]/
    if (
      position.x + 1 < matrix.length &&
      position.y + 1 < matrix[position.x + 1].length &&
      matrix[position.x + 1][position.y + 1].match(symbolRegex)
    ) {
      return true
    }
    if (
      position.x + 1 < matrix.length &&
      position.y < matrix[position.x + 1].length &&
      matrix[position.x + 1][position.y].match(symbolRegex)
    ) {
      return true
    }
    if (
      position.x + 1 < matrix.length &&
      position.y - 1 > 0 &&
      matrix[position.x + 1][position.y - 1].match(symbolRegex)
    ) {
      return true
    }
    if (
      position.x < matrix.length &&
      position.y + 1 < matrix[position.x].length &&
      matrix[position.x][position.y + 1].match(symbolRegex)
    ) {
      return true
    }
    if (
      position.x < matrix.length &&
      position.y - 1 > 0 &&
      matrix[position.x][position.y - 1].match(symbolRegex)
    ) {
      return true
    }
    if (
      position.x - 1 > 0 &&
      position.y - 1 > 0 &&
      matrix[position.x - 1][position.y - 1].match(symbolRegex)
    ) {
      return true
    }
    if (
      position.x - 1 > 0 &&
      position.y < matrix[position.x - 1].length &&
      matrix[position.x - 1][position.y].match(symbolRegex)
    ) {
      return true
    }
    if (
      position.x - 1 > 0 &&
      position.y + 1 < matrix[position.x - 1].length &&
      matrix[position.x - 1][position.y + 1].match(symbolRegex)
    ) {
      return true
    }
    return false
  }
}
