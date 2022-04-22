package net.soy.algorithm.codility

/**
 * Algorithm
 * N 개의 정수 A 배열이 주어지면 A에서 발생하지 않는 가장 작은 양의 정수 (0보다 큼)를 반환합니다.
 * @author leesoyoung
 * @since 2022/04/21
 */

class MissingInteger {
    fun solution(A: IntArray): Int {
        val set: MutableSet<Int> = HashSet()
        for (a in A) {
            set.add(a)
        }
        for (i in 1..Int.MAX_VALUE) {
            if (!set.contains(i)) {
                return i
            }
        }
        return -1
    }
}