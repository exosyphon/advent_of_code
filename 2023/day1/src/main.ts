import fs from "fs"

export class Main {
  public calibrations(): number {
    let sum = 0

    const allFileContents = fs.readFileSync("./src/input.txt", "utf-8")
    allFileContents.split(/\r?\n/).forEach((line: string) => {
      if (line.length > 0) {
        sum = sum + this.calibration(line)
      }
    })

    return sum
  }

  public calibration(input: string): number {
    const onlyNumbers: string = input.replace(/\D/g, "")
    return Number(`${onlyNumbers[0]}${onlyNumbers[onlyNumbers.length - 1]}`)
  }
}

console.log(new Main().calibrations())
