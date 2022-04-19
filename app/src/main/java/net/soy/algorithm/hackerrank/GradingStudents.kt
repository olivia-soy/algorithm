package net.soy.algorithm.hackerrank

/**
 * Algorithm
 * Grading Students
 * @author leesoyoung
 * @since 2022/04/19
 */

class GradingStudents {
    fun solution(grades: Array<Int>): Array<Int> {
        return grades.map {
            when {
                it < 38 -> {
                    it
                }
                it.rem(5) >= 3 -> {
                    it + (5 - it.rem(5))
                }
                else -> {
                    it
                }
            }
        }.toTypedArray()
    }
}