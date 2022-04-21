package net.soy.algorithm.codility

/**
 * # Algorithm
 * # CyclicRotation
 * @author LEESOYOUNG
 * @since 2022-03-08
 */
class CyclicRotation {
    /**
     * N 개의 정수와 정수 K로 구성된 배열 A가 주어지면 배열 A를 회전 K 번 반환합니다.
     */
    fun solution(A: IntArray, K: Int): IntArray {
        val answerArray = IntArray(A.size)
        for (i in A.indices) {
            /**
             * index 값 계산 -> i +K 칸씩 이동하면서 IntArray A.size - 1 보다 클 경우에는 i+k 에서 A.size 를 나눈 나머지 값만큼 이동한다
             */
            answerArray[if ((i + K) > (A.size - 1)) {
                (i + K) % A.size
            } else {
                (i + K)
            }] = A[i]
        }
        return answerArray
    }

    /* fun solution(A: IntArray, K: Int): IntArray {
         val indexArray = arrayListOf<Int>()
         for (i in A.indices) {
             indexArray.add(
                 if ((i + K) > (A.size - 1)) {
                     (i + K) % A.size
                 } else {
                     (i + K)
                 }
             )
         }

         println(indexArray)
         val newArray =IntArray(A.size)
         indexArray.forEachIndexed { index, i ->
             newArray[i] = A[index]
         }

         println(newArray)
         return newArray
     }*/
}