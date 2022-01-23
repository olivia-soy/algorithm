package net.soy.algorithm.codingTest

/**
 * Algorithm
 * mobility
 * @author LEESOYOUNG
 * @since 2022/01/21
 */
class Test1 {
    fun solution(A: Array<String>, B: Array<String>, P: String): String {
        val answerArray = arrayListOf<String>()
        B.forEachIndexed { index, s ->
            if (s.contains(P)) {
                answerArray.add(A[index])
            }
        }

        return if (answerArray.isEmpty())
            "NO CONTACT"
        else answerArray.sorted().first()
    }
}