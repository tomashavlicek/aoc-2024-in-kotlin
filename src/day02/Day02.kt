package day02

import println
import readInput
import kotlin.math.absoluteValue

fun main() {

    fun isSafe(report: List<Int>): Boolean {
        var isIncreasing = true
        var isDecreasing = true
        for (i in 0..< report.lastIndex) {
            val difference = report[i] - report[i + 1]
            if (difference < 0) {
                isIncreasing = false
            }
            if (difference > 0) {
                isDecreasing = false
            }
            if (difference.absoluteValue !in (1..3)) {
                return false
            }
        }
        return isIncreasing || isDecreasing
    }

    fun part1(input: List<String>): Int {
        val reports = input.map { it.split(' ').map { it.toInt() } }
        return reports.count { isSafe(it) }
    }

    fun part2(input: List<String>): Int {
        val reports = input.map { it.split(' ').map { it.toInt() } }
        var result = 0
        for (report in reports) {
            var safe = false
            for (i in 0..report.lastIndex) {
                safe = isSafe(report.toMutableList().apply { removeAt(i)})
                if (safe) { break }
            }
            if (safe) result++
        }

        return result
    }

    val fileName =
        "day02/input02"
//        "day02/sample02"

    val input = readInput(fileName)

    part1(input).println()
    part2(input).println()
}