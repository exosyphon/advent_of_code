import { describe, expect, test } from "bun:test"
import { Main } from "../src/main"

describe("Main", () => {
  test("first case", () => {
    expect(new Main().calibration("1abc2")).toBe(12)
  })
})
