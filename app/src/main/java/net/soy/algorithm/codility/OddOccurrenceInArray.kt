package net.soy.algorithm.codility

import java.util.*

/**
 * # Algorithm
 * # OddOccurrenceInArray
 * @author LEESOYOUNG
 * @since 2022-03-10
 */
class OddOccurrenceInArray {
    /**
     * N개의 정수로 구성된 비어 있지 않은 배열 A가 주어진다.
     * 배열에 홀수 개수의 요소가 포함되어 있으며,
     * 배열의 각 요소는 쌍을 이루지 않은 한 요소를 제외하고 동일한 값을 가진 다른 요소와 쌍을 이룰 수 있습니다.
     * 위의 조건을 충족하는 N 개의 정수로 구성된 배열 A가 주어지면 쌍이 없는 요소의 값을 반환합니다.
     */
    fun solution(A: IntArray): Int {
        var answer = 0
        val stack = LinkedList<Int>()
        stack.addAll(A.toList())

        while (stack.isNotEmpty()){
            val first = stack.pop()
            if(stack.contains(first)){
                stack.remove(first)
            } else {
                answer = first
                break
            }
        }
        return  answer
    }
}
