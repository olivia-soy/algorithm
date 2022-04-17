package net.soy.algorithm.hackerrank

import kotlin.math.abs


/**
 * Algorithm
 * Diagonal Difference
 * @author leesoyoung
 * @since 2022/04/17
 */

class DiagonalDifference {
    /**
     * 정사각형 행렬이 주어지면 대각선의 합들 사이의 절대 차이를 계산합니다.
     */
    fun solution(arr: Array<Array<Int>>): Int {
        var a = 0
        var b = 0
        arr.forEachIndexed { index, _ ->
            a += arr[index][index]
            b += arr[(arr.size -1) - index][index]
        }

        return abs(a -b)
    }
}