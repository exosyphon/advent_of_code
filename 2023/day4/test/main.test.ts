import { describe, expect, test } from "bun:test"
import { Main } from "../src/main"

describe("Main", () => {
  test("first case", () => {
    expect(new Main().processCard("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53")).toBe(8)
  })
  test("second case", () => {
    expect(new Main().processCard("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19")).toBe(2)
  })
  test("third case", () => {
    expect(new Main().processCard("Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1")).toBe(2)
  })
  test("fourth case", () => {
    expect(new Main().processCard("Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83")).toBe(1)
  })
  test("fifth case", () => {
    expect(new Main().processCard("Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36")).toBe(0)
  })
  test("sixth case", () => {
    expect(new Main().processCard("Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11")).toBe(0)
  })
  test("full input part 1", () => {
    expect(new Main().execute()).toBe(25571)
  })
})
