import fs from "fs"

export class Main {
  public execute(part2 = false): number {
    const allFileContents = fs.readFileSync("./src/input.txt", "utf-8")
    // return allFileContents.split(/\r?\n/).reduce((acc: number, line: string) => {
    //   return acc + this.processCard(line)
    // }, 0)

    let sum = 0
    allFileContents.split("\n").forEach((line: string) => {
      if (line.length > 0) {
        sum = sum + this.processCard(line)
      }
    })
    return sum
  }

  public processCard(input: string): number {
    const [setA, setB] = input.split(/:\s+/)[1].split(/\|\s+/).map((numbers: string) => {
      return numbers.split(/\s+/)
    })

    return Math.floor(Math.pow(2, setB.filter(value => setA.includes(value)).length - 1))
  }
}
