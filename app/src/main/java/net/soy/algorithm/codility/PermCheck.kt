package net.soy.algorithm.codility

import java.util.*

/**
 * # Algorithm
 * # Check whether array A is a permutation. [66%] -> [91%]
 * @author LEESOYOUNG
 * @since 2022-04-07
 *
 * treeSet 사용 -> 정렬, 중복 허용 X
 * 순열에서 첫 원소가 1이 아니면 조건에 해당되지 않는다
 */
class PermCheck {
    /**
     * N개의 정수로 이루어진 비어 있지 않은 배열 A가 주어진다.
     * 순열은 1에서 N까지의 각 원소를한 번만 포함하는 시퀀스입니다.
     *
     * 배열 A가 주어지면 배열 A가 순열이면 1을 반환하고 그렇지 않으면 0을 반환합니다.
     */
    fun solution(A: IntArray): Int {
        val treeSet = TreeSet<Int>()
        treeSet.addAll(A.toList())
        val first = treeSet.first()
        if (first != 1 || A.size != treeSet.size) {
            return 0
        }
        val last = treeSet.last()
        return if (last == first + A.size - 1) 1 else 0
    }
}