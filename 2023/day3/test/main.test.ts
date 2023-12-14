import { describe, expect, test } from "bun:test"
import { Main } from "../src/main"

describe("Main", () => {
  test("part 1 first case", () => {
    expect(new Main().execute({ test: true })).toBe(4361)
  })
  test("part 1 full case", () => {
    expect(new Main().execute()).toBe(539433)
  })
  test("part 2 first case", () => {
    expect(new Main().execute({ test: true, part2: true })).toBe(467835)
  })
  test("part 2 full case", () => {
    expect(new Main().execute({ part2: true })).toBe(75847567)
  })
})
