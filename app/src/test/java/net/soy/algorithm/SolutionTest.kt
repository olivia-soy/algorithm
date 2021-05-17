package net.soy.algorithm

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SolutionTest {

    @Test
    fun solution() {
        var numbers: IntArray = intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5)
        var hand: String = "right"
        var answer = ""
        val LEFT = "left"
        val leftArray = intArrayOf(1, 4, 7)
        val RIGHT = "right"
        val rightArray = intArrayOf(3, 6, 9)
        var leftPosition = 10
        var rightPosition = 11


        numbers.forEach {
            when {
                leftArray.contains(it) -> {
                    answer += "L"
                    leftPosition = it
                }
                rightArray.contains(it) -> {
                    answer += "R"
                    rightPosition = it
                }
                else -> {
                    answer += "_"
                }
            }
        }

        println(answer)

    }

    fun Pair<Int, Int>.distance(pair: Pair<Int, Int>): Int =
        sqrt((this.first - pair.first).toDouble().pow(2))
}
