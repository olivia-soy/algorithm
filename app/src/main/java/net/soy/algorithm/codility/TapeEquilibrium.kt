package net.soy.algorithm.codility

import kotlin.math.abs

/**
 * # Algorithm
 * # TapeEquilibrium
 * @author LEESOYOUNG
 * @since 2022-04-01
 */
class TapeEquilibrium {

    fun solution(A: IntArray): Int {
        // write your code in Kotlin 1.3.11 (Linux)

        val answer = arrayListOf<Int>()
        for (p in A.indices) {
            var a = 0
            var b = 0
            for (i in 0 until p) {
                a += A[i]
            }
            for (i in p until A.size) {
                b += A[i]
            }
            answer.add(abs(a - b))
        }

        var min = Int.MAX_VALUE
        for (i in 0 until answer.size) {
            if (min > answer[i]) {
                min = answer[i]
            }
        }
        return min
    }
}