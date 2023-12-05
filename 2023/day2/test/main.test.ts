import { describe, expect, test } from "bun:test"
import { Main } from "../src/main"

// 12 red cubes, 13 green cubes, and 14 blue cubes
describe("Main", () => {
  test("part 1 first case", () => {
    expect(new Main().isPossible("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")).toBe(true)
  })
  test("part 1 second case", () => {
    expect(new Main().isPossible("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue")).toBe(true)
  })
  test("part 1 third case", () => {
    expect(new Main().isPossible("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red")).toBe(false)
  })
  test("part 1 fourth case", () => {
    expect(new Main().isPossible("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red")).toBe(false)
  })
  test("part 1 fifth case", () => {
    expect(new Main().isPossible("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green")).toBe(true)
  })
  test("part 1 case", () => {
    expect(new Main().execute()).toBe(2076)
  })

  test("part 2 first case", () => {
    expect(new Main().minPossible("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")).toBe(48)
  })
  test("part 2 second case", () => {
    expect(new Main().minPossible("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue")).toBe(12)
  })
  test("part 2 third case", () => {
    expect(new Main().minPossible("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red")).toBe(1560)
  })
  test("part 2 fourth case", () => {
    expect(new Main().minPossible("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red")).toBe(630)
  })
  test("part 2 fifth case", () => {
    expect(new Main().minPossible("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green")).toBe(36)
  })
  test("part 2 case", () => {
    expect(new Main().execute(true)).toBe(70950)
  })
})
