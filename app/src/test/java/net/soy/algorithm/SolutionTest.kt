package net.soy.algorithm

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.abs
import kotlin.math.hypot
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
        var answer = ""
        val LEFT = "left"
        val leftArray = intArrayOf(1, 4, 7)
        val RIGHT = "right"
        val hand = "right"
        val rightArray = intArrayOf(3, 6, 9)
        var leftPosition: Any = "*"
        var rightPosition: Any = "#"


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
                    val numLocation = it.convertToLocation()
                    val leftDistance = leftPosition.convertToLocation().distance(numLocation)
                    val rightDistance = rightPosition.convertToLocation().distance(numLocation)
                    when {
                        leftDistance > rightDistance -> {
                            answer += "R"
                            rightPosition = it
                        }
                        leftDistance < rightDistance -> {
                            answer += "L"
                            leftPosition = it
                        }
                        leftDistance == rightDistance -> {
                            when (hand) {
                                LEFT -> {
                                    answer += "L"
                                    leftPosition = it
                                }
                                else -> {
                                    answer += "R"
                                    rightPosition = it
                                }
                            }
                        }
                    }
                }
            }
        }

        println(answer)
    }

    @Test
    fun DistanceTest() {

    }

    fun Any.convertToLocation(): Pair<Int, Int> {
        return when (this) {
            1 -> Pair(0, 3)
            2 -> Pair(1, 3)
            3 -> Pair(2, 3)
            4 -> Pair(0, 2)
            5 -> Pair(1, 2)
            6 -> Pair(2, 2)
            7 -> Pair(0, 1)
            8 -> Pair(1, 1)
            9 -> Pair(2, 1)
            "*" -> Pair(0, 0)
            0 -> Pair(1, 0)
            "#" -> Pair(2, 0)
            else -> Pair(-1, -1)
        }
    }


    fun Pair<Int, Int>.distance(pair: Pair<Int, Int>): Double =
        hypot((this.first - pair.first).toDouble(), (this.second - pair.second).toDouble())
}

