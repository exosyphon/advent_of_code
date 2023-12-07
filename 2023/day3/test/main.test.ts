import { describe, expect, test } from "bun:test"
import { Main } from "../src/main"

describe("Main", () => {
  test("first case", () => {
    expect(new Main().execute({ test: true })).toBe(4361)
  })
  test("full case", () => {
    expect(new Main().execute()).toBe(539433)
  })
})
