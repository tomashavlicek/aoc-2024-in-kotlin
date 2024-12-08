package day03

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var result = 0
        val mulRegex = """mul\((\d{1,3}),(\d{1,3})\)""".toRegex()
        for (line in input) {
            val matched = mulRegex.findAll(line)
            for (match in matched) {
                val (a, b) = match.destructured
                result += a.toInt() * b.toInt()
            }
        }
        return result
    }

    fun part2(input: List<String>): Int {
        val mulRegex = """do\(\)|mul\((\d{1,3}),(\d{1,3})\)|don't\(\)""".toRegex()
        var result = 0
        var enable = true
        for (line in input) {
            for (match in mulRegex.findAll(line)) {
                when (match.value) {
                    "do()" -> enable = true
                    "don't()" -> enable = false
                    else -> {
                        if (enable) {
                            val (a, b) = match.destructured
                            result += a.toInt() * b.toInt()
                        }
                    }
                }
            }
        }
        return result
    }

    val fileName =
        "day03/input03"
//        "day03/sample03"

    val input = readInput(fileName)

    part1(input).println()
    part2(input).println()
}
