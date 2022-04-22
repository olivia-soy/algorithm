package net.soy.algorithm.codility

/**
 * # Algorithm
 * # PermMissingElem
 * @author LEESOYOUNG
 * @since 2022-03-22
 */
class PermMissingElem {
    /**
     * N개의 서로 다른 정수로 이루어진 배열 A가 주어진다.
     * 배열은 [1] 범위의 정수를 포함합니다.(N + 1)]는 정확히 하나의 요소가 없음을 의미합니다.
     * 여러분의 목표는 그 누락된 요소를 찾는 것입니다.
     */
    fun solution(A: IntArray): Int {
        var answer = 1
        if (A.isEmpty()) {
            return answer
        }
        val sortedList = A.sortedArray()
        for (i in sortedList) {
            if (answer == i) {
                answer++
            } else {
                break
            }
        }
        return answer
    }
}