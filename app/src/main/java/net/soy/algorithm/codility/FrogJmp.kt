package net.soy.algorithm.codility

import kotlin.math.ceil

/**
 * # Algorithm
 * # FrogJmp
 * @author LEESOYOUNG
 * @since 2022-03-18
 */

class FrogJmp {
    /**
     * 작은 개구리는 길 반대편으로 가고 싶어한다.
     * 개구리는 현재 X 위치에 있으며 Y보다 크거나 같은 위치에 도달하려고합니다.
     * 작은 개구리는 항상 일정한 거리를 점프하는데,
     * D.  작은 개구리가 목표에 도달하기 위해 수행해야하는 최소 점프 수를 계산하십시오.
     *
     * 3개의 정수 X, Y, D가 주어졌을 때, X 위치에서 Y 이상의 위치로 점프하는 최소 횟수를 반환한다.
     */
    fun solution(X: Int, Y: Int, D: Int): Int {
        if (Y - X <= 0) {
            return 0
        }
        val count: Double = (Y - X)/D.toDouble() // 소수점도 출력하기 위해서 toDouble 사용
        return ceil(count).toInt()  //올림 적용
    }
}