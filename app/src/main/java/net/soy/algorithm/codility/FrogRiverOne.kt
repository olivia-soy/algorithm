package net.soy.algorithm.codility

/**
 * # Algorithm
 * # FrogRiverOne
 * @author LEESOYOUNG
 * @since 2022-04-04
 */
class FrogRiverOne {
    fun solution(X: Int, A: IntArray): Int {
        // write your code in Kotlin 1.3.11 (Linux)
        val answerList = IntArray(X)
        var answer = -1

        run loop@{
            A.forEachIndexed { index, it ->
                if (answerList[it - 1] == 0) {
                    answerList[it - 1] = it
                }
                if (!answerList.contains(0)) {
                    answer = index
                    return@loop
                }
            }
        }
        return answer
    }
}