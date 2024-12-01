package day01

import println
import readInput
import kotlin.math.abs

fun main() {
    fun part1(leftList: List<Int>, rightList: List<Int>): Int {
        val leftListSorted = leftList.toMutableList().apply { sort() }
        val rightListSorted = rightList.toMutableList().apply { sort() }

        var result = 0
        leftListSorted.forEachIndexed { index, i ->
            result += abs(rightListSorted[index] - i)
        }
        return result

    }

    fun part2(leftList: List<Int>, rightList: List<Int>): Int {
        var result = 0
        leftList.forEach { givenNumber ->
            result += givenNumber * rightList.count { it == givenNumber }
        }
        return result
    }

    val fileName =
        "day01/input01"
//        "day01/sample01"

    val leftList = mutableListOf<Int>()
    val rightList = mutableListOf<Int>()
    val inputLineRegex = """(\d+)   (\d+)""".toRegex()

    // Read the input from the `src/Day01.txt` file.
    val input = readInput(fileName).map { line ->
        val result = inputLineRegex.matchEntire(line)?.destructured
            ?: throw IllegalArgumentException("Incorrect input line $line")
        leftList.add(result.component1().toInt())
        rightList.add(result.component2().toInt())
    }

//    part1(leftList, rightList).println()
    part2(leftList, rightList).println()
}