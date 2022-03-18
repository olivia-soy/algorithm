package net.soy.algorithm.codility

import kotlin.math.ceil

/**
 * # Algorithm
 * # FrogJmp
 * @author LEESOYOUNG
 * @since 2022-03-18
 */

class FrogJmp {
    fun solution(X: Int, Y: Int, D: Int): Int {
        if (Y - X <= 0) {
            return 0
        }
        val count: Double = (Y - X)/D.toDouble() // 소수점도 출력하기 위해서 toDouble 사용
        return ceil(count).toInt()  //올림 적용
    }
}