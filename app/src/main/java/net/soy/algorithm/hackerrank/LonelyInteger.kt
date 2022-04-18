package net.soy.algorithm.hackerrank

/**
 * # Algorithm
 * # Lonely Integer
 * @author LEESOYOUNG
 * @since 2022-04-18
 */
class LonelyInteger {
    /**
     * 하나의 원소를 제외한 모든 원소가 두 번 발생하는 정수의 배열이 주어지면 두 번 발생하지 않은 원소를 찾으시오
     */
    fun solution(a: Array<Int>): Int {
        return a.groupBy { it }.filterValues { it.size == 1 }.keys.first()
    }
}