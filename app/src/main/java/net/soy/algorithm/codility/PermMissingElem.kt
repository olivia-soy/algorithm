package net.soy.algorithm.codility

/**
 * # Algorithm
 * # PermMissingElem
 * @author LEESOYOUNG
 * @since 2022-03-22
 */
class PermMissingElem {
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