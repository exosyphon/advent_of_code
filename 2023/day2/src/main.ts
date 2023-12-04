import fs from "fs"

export class Main {
  public execute(part2 = false): number {
    const allFileContents = fs.readFileSync("./src/input.txt", "utf-8")
    // allFileContents.split(/\r?\n/).forEach((line: string) => {
    // })

    return 0
  }

}
