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

    /**
     * N개의 정수로 구성된 비어 있지 않은 배열 A가 주어진다.
     * A 배열은 테이프에 있는 숫자를 나타냅니다.
     * 0 < P < N과 같은 정수 P는 이 테이프를 비어 있지 않은 두 부분으로 나눕니다.
     * A[0], A[1], ..., A[P - 1] 및 A[P], A[P + 1], ..., A[N - 1].
     * 두 부분의 차이는 |(A[0] + A[1] + ...의 값이다. + A[P - 1]) - (A[P] + A[P + 1] + ... + A[N - 1]|
     * 즉, 첫 번째 부분의 합과 두 번째 부분의 합과의 절대적인 차이입니다.
     *
     * N개의 정수 배열 A가 비어 있지 않은 경우, 얻을 수 있는 최소 차이를 반환합니다.
     *
     * N = A.size
     */
    fun solution(A: IntArray): Int {

        var answer = Int.MAX_VALUE

        val sumAll = A.sum()
        var left = 0
        var right = 0

        for (p in 1 until A.size) {
            left += A[p - 1]
            right = sumAll - left
            val abs = abs(left - right)
            if (answer > abs)
                answer = abs
        }

        return answer
    }
}