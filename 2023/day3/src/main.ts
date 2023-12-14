import fs, { watch } from "fs"

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

  private getNumber(matrix: string[][], position: Position): number {
    //console.log("scanning")
    let result = ""
    for (let j = position.y; j >= 0; j--) {
      //console.log(`checking ${matrix[position.x][j]}`)
      if (matrix[position.x][j].match(/\d/)) {
        //console.log(`result before: ${result}`)
        result = `${matrix[position.x][j]}${result}`
        //console.log(`result before: ${result}`)
      } else {
        break
      }
    }
    for (let j = position.y + 1; j < matrix[position.x].length; j++) {
      //console.log(`checking ${matrix[position.x][j]}`)
      if (matrix[position.x][j].match(/\d/)) {
        //console.log(`result before: ${result}`)
        result = `${result}${matrix[position.x][j]}`
        //console.log(`result before: ${result}`)
      } else {
        break
      }
    }
    return Number(result)
  }

  private getNumbers(matrix: string[][], position: Position): number[] {
    let numbers: number[] = []
    const symbolRegex = /\d/
    if (
      position.x + 1 < matrix.length &&
      position.y + 1 < matrix[position.x + 1].length &&
      matrix[position.x + 1][position.y + 1].match(symbolRegex)
    ) {
      //console.log("adj1")
      numbers = numbers.concat(
        this.getNumber(matrix, { x: position.x + 1, y: position.y + 1 }),
      )
    }
    if (
      position.x + 1 < matrix.length &&
      position.y < matrix[position.x + 1].length &&
      matrix[position.x + 1][position.y].match(symbolRegex)
    ) {
      //console.log("adj2")
      numbers = numbers.concat(
        this.getNumber(matrix, { x: position.x + 1, y: position.y }),
      )
    }
    if (
      position.x + 1 < matrix.length &&
      position.y - 1 >= 0 &&
      matrix[position.x + 1][position.y - 1].match(symbolRegex)
    ) {
      //console.log("adj3")
      numbers = numbers.concat(
        this.getNumber(matrix, { x: position.x + 1, y: position.y - 1 }),
      )
    }
    if (
      position.x < matrix.length &&
      position.y + 1 < matrix[position.x].length &&
      matrix[position.x][position.y + 1].match(symbolRegex)
    ) {
      //console.log("adj4")
      numbers = numbers.concat(this.getNumber(matrix, position))
    }
    if (
      position.x < matrix.length &&
      position.y - 1 >= 0 &&
      matrix[position.x][position.y - 1].match(symbolRegex)
    ) {
      //console.log("adj5")
      numbers = numbers.concat(
        this.getNumber(matrix, { x: position.x, y: position.y - 1 }),
      )
    }
    //console.log(`why no adj6? ${matrix[position.x - 1][position.y - 1]}`)
    //console.log(`why no adj6 bro? ${matrix[position.x - 1][position.y - 1].match(symbolRegex)}`)
    if (
      position.x - 1 >= 0 &&
      position.y - 1 >= 0 &&
      matrix[position.x - 1][position.y - 1].match(symbolRegex)
    ) {
      //console.log("adj6")
      numbers = numbers.concat(
        this.getNumber(matrix, { x: position.x - 1, y: position.y - 1 }),
      )
    }
    if (
      position.x - 1 >= 0 &&
      position.y < matrix[position.x - 1].length &&
      matrix[position.x - 1][position.y].match(symbolRegex)
    ) {
      //console.log("adj7")
      numbers = numbers.concat(
        this.getNumber(matrix, { x: position.x - 1, y: position.y }),
      )
    }
    if (
      position.x - 1 >= 0 &&
      position.y + 1 < matrix[position.x - 1].length &&
      matrix[position.x - 1][position.y + 1].match(symbolRegex)
    ) {
      //console.log("adj8")
      numbers = numbers.concat(
        this.getNumber(matrix, { x: position.x - 1, y: position.y + 1 }),
      )
    }
    const temp = new Set(numbers)
    return [...temp]
  }

  public execute({ test = false, part2 = false } = {}): number {
    const arr = this.readInput(test)
    // arr.forEach((v) => //console.log(...v))

    let sum = 0
    if (part2) {
      for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr[i].length; j++) {
          if (arr[i][j].match(/\*/)) {
            //console.log("found a *")
            const numbers = this.getNumbers(arr, { x: i, y: j })
            //console.log(`got these numbers ${numbers}`)
            if (numbers.length == 2) {
              //console.log(numbers)
              sum += numbers[0] * numbers[1]
            }
          }
        }
      }
    } else {
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
