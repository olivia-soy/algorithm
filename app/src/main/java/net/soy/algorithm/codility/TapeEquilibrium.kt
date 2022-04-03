package net.soy.algorithm.codility

import kotlin.math.abs

/**
 * # Algorithm
 * # TapeEquilibrium
 * @author LEESOYOUNG
 * @since 2022-04-01
 *
 * 2차 풀이 69%
 */
class TapeEquilibrium {

    fun solution(A: IntArray): Int {

        var answer = Int.MAX_VALUE
        for (p in 1 until A.size) {
            var a = 0
            var b = 0
            for (i in 0 until p) {
                a += A[i]
            }
            for (i in p until A.size) {
                b += A[i]
            }
            val test = abs(a - b)
            if (answer > test)
                answer = test
        }

        return answer
    }
}