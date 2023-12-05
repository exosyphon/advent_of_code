import fs from "fs"

type Game = {
  red: number
  green: number
  blue: number
}

export class Main {
  public execute(part2 = false): number {
    const allFileContents = fs.readFileSync("./src/input.txt", "utf-8")
    return allFileContents.split("\n").reduce((acc: number, line: string, index: number) => {
      if (line.length > 0) {
        if (part2) {
          return acc + this.minPossible(line)
        } else {
          return acc + (this.isPossible(line) ? index + 1 : 0)
        }
      } else {
        return acc
      }
    }, 0)
  }

  public minPossible(input: string): number {
    const games = input.split(/:\s+/)[1].split(/;\s+/)
    const gameResults: Game[] = games.map((game: string) => {
      return game.split(/,\s+/).reduce((acc: Game, cubes: string) => {
        const cubesObj = cubes.split(" ")
        acc[cubesObj[1]] = Number(cubesObj[0])
        return acc
      }, {})
    })

    const minCubes: Game = { red: -Infinity, green: -Infinity, blue: -Infinity }
    gameResults.forEach((gameResult) => {
      if (gameResult.red > minCubes.red) {
        minCubes.red = gameResult.red
      }
      if (gameResult.blue > minCubes.blue) {
        minCubes.blue = gameResult.blue
      }
      if (gameResult.green > minCubes.green) {
        minCubes.green = gameResult.green
      }
    })

    return minCubes.red * minCubes.green * minCubes.blue
  }

  public isPossible(input: string): boolean {
    const games = input.split(/:\s+/)[1].split(/;\s+/)
    const gameResults: Game[] = games.map((game: string) => {
      return game.split(/,\s+/).reduce((acc: Game, cubes: string) => {
        const cubesObj = cubes.split(" ")
        acc[cubesObj[1]] = Number(cubesObj[0])
        return acc
      }, {})
    })

    return gameResults.filter((gameResult) => gameResult.red > 12 || gameResult.green > 13 || gameResult.blue > 14).length == 0
  }
}
