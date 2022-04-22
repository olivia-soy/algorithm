package net.soy.algorithm.codility

/**
 * # Algorithm
 * # Count Div
 * @author LEESOYOUNG
 * @since 2022-04-22
 */
class CountDiv {
    /**
     * 세 개의 정수 A, B, K가 주어졌을 때
     * [A . . B] 범위 내의 정수 수를 반환합니다 K로 나눌 수 있는
     * 예를 들어, A = 6, B = 11 및 K = 2의 경우 [6 . 11] 범위 내에서 2로 나눌 수 있는 세 개의 숫자, 즉 6, 8, 10이 있으므로 함수는 3을 반환해야 합니다.
     *
     * div -> 몫
     * rem -> 나머지
     */
    fun solution(A: Int, B: Int, K: Int): Int {
        //B를 K로 나눈 몫 - A를 K로 나눈 몫 (A 가 K의 배수일 경우 +1)
        return B.div(K) - A.div(K) + if(A.rem(K) == 0) + 1 else 0
    }

}