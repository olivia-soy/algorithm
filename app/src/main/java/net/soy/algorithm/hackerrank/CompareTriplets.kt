package net.soy.algorithm.hackerrank

/**
 * Algorithm
 *
 * @author leesoyoung
 * @since 2022/04/16
 */

class CompareTriplets {

    fun solution(a: Array<Int>, b: Array<Int>): Array<Int> {
        var answerA = 0
        var answerB = 0
        a.forEachIndexed { index, i ->
            when{
                i > b[index] -> {
                    answerA += 1
                }
                b[index] > i -> {
                    answerB += 1
                }
            }
        }

        return arrayOf(answerA, answerB)
    }
}