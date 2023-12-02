import fs from "fs"

export class Main {
  public calibrations(part2 = false): number {
    let sum = 0

    const allFileContents = fs.readFileSync("./src/input.txt", "utf-8")
    allFileContents.split("\n").forEach((line: string) => {
      if (line.length > 0) {
        if (part2) {
          sum = sum + this.improvedCalibrations(line)
        } else {
          sum = sum + this.calibration(line)
        }
      }
    })

    return sum
  }

  public improvedCalibrations(input: string): number {
    const numbers: { [key: string]: number } = {
      "1": 1,
      "2": 2,
      "3": 3,
      "4": 4,
      "5": 5,
      "6": 6,
      "7": 7,
      "8": 8,
      "9": 9,
      one: 1,
      two: 2,
      three: 3,
      four: 4,
      five: 5,
      six: 6,
      seven: 7,
      eight: 8,
      nine: 9,
    }

    const indexes = Object.entries(numbers).flatMap(([key, value]) => {
      return this.getAllIndexes(input, key).map((index) => {
        return { index: index, value: value }
      })
    }).filter((entry) => entry.index != -1)

    const maxObj = indexes.reduce((mObj, obj) => {
      return obj.index > mObj.index ? obj : mObj
    },
      { index: -Infinity },
    )

    const minObj = indexes.reduce((mObj, obj) => {
      return obj.index < mObj.index ? obj : mObj
    },
      { index: Infinity },
    )

    return Number(`${minObj.value}${maxObj.value}`)
  }

  private getAllIndexes(mainString: string, subString: string): number[] {
    const indexes: number[] = []
    let currentIndex = mainString.indexOf(subString)

    while (currentIndex !== -1) {
      indexes.push(currentIndex)
      currentIndex = mainString.indexOf(subString, currentIndex + 1)
    }

    return indexes
  }

  public calibration(input: string): number {
    const onlyNumbers: string = input.replace(/\D/g, "")
    return Number(`${onlyNumbers[0]}${onlyNumbers[onlyNumbers.length - 1]}`)
  }
}
