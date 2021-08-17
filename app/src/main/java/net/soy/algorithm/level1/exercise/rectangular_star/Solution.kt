package net.soy.algorithm.level1.exercise.rectangular_star

/**
 * Algorithm
 *
 * @author LEESOYOUNG
 * @since 2021-08-18
 */
class Solution {
    fun main(args: Array<String>) {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        println(solution(arrayOf(a, b)))
    }

    fun solution(args: Array<Int>): String {
        val (a, b) = args;
        val result = StringBuilder()
        for (i: Int in 1..b) {
            for (j: Int in 1..a) {
                result.append("*")
            }
            result.append("\n")
        }

        return result.toString()
    }
}