import { describe, expect, test } from "bun:test"
import { Main } from "../src/main"

describe("Main", () => {
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

  test("part 2 first case", () => {
    expect(new Main().improvedCalibrations("two1nine")).toBe(29)
  })
  test("part 2 second case", () => {
    expect(new Main().improvedCalibrations("eightwothree")).toBe(83)
  })
  test("part 2 third case", () => {
    expect(new Main().improvedCalibrations("abcone2threexyz")).toBe(13)
  })
  test("part 2 fourth case", () => {
    expect(new Main().improvedCalibrations("xtwone3four")).toBe(24)
  })
  test("part 2 fifth case", () => {
    expect(new Main().improvedCalibrations("4nineeightseven2")).toBe(42)
  })
  test("part 2 sixth case", () => {
    expect(new Main().improvedCalibrations("zoneight234")).toBe(14)
  })
  test("part 2 seventh case", () => {
    expect(new Main().improvedCalibrations("7pqrstsixteen")).toBe(76)
  })
  test("part 2 special case 1", () => {
    expect(new Main().improvedCalibrations("eighthree")).toBe(83)
  })
  test("part 2 special case 2", () => {
    expect(new Main().improvedCalibrations("oneight")).toBe(18)
  })
  test("part 2 special case 3", () => {
    expect(new Main().improvedCalibrations("abc2x3oneight")).toBe(28)
  })
  test("part 2 special case 4", () => {
    expect(new Main().improvedCalibrations("f3")).toBe(33)
  })
  test("part 2 special case 5", () => {
    expect(new Main().improvedCalibrations("two934seven1")).toBe(21)
  })
  test("part 2 special case 6", () => {
    expect(new Main().improvedCalibrations("8825eightknfv")).toBe(88)
  })
  test("part 2 special case 7", () => {
    expect(new Main().improvedCalibrations("sevenoneqbfzntsix55")).toBe(75)
  })
  test("part 2 special case 8", () => {
    expect(new Main().improvedCalibrations("4twofour")).toBe(44)
  })
  test("part 2 special case 9", () => {
    expect(new Main().improvedCalibrations("573")).toBe(53)
  })
  test("part 2 special case 10", () => {
    expect(new Main().improvedCalibrations("5n")).toBe(55)
  })
  test("part 2 special case 11", () => {
    expect(new Main().improvedCalibrations("265one")).toBe(21)
  })
  test("part 2 special case 12", () => {
    expect(new Main().improvedCalibrations("seven3lbcvjxqhhdpzkttqsixjzzjjbclfq1fiveeightwojx")).toBe(72)
  })
  test("part 2 special case 13", () => {
    expect(new Main().improvedCalibrations("38sevennineninemnfzklttkxnine3")).toBe(33)
  })
  test("part 2 full case", () => {
    expect(new Main().calibrations(true)).toBe(53340)
  })
})
