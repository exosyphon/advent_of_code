import { expect, test } from "bun:test"
import { Main } from "../src/main"

test("first case", () => {
  expect(new Main().calibration("1abc2")).toBe(12)
})
test("second case", () => {
  expect(new Main().calibration("pqr3stu8vwx")).toBe(38)
})
test("third case", () => {
  expect(new Main().calibration("a1b2c3d4e5f")).toBe(15)
})
test("fourth case", () => {
  expect(new Main().calibration("treb7uchet")).toBe(77)
})
test("test file case", () => {
  expect(new Main().calibrations()).toBe(52974)
})
