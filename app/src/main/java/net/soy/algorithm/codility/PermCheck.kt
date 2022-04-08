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