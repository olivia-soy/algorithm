package net.soy.algorithm.codility

import java.util.*

/**
 * # Algorithm
 * # OddOccurrenceInArray
 * @author LEESOYOUNG
 * @since 2022-03-10
 */
class OddOccurrenceInArray {
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
