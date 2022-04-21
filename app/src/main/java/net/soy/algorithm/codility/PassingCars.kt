package net.soy.algorithm.codility

/**
 * Algorithm
 *
 * @author leesoyoung
 * @since 2022/04/21
 */

class PassingCars {
    /**
     * 지나가는 차를 세는 것이 목표다.
     * 우리는 P가 동쪽으로, Q가 서쪽으로 이동할 때
     * 0 μP < Q < N인 한 쌍의 차(P, Q)가 통과한다고 말한다.
     *
     * N개의 정수 배열 A가 비어 있지 않을 경우 지나가는 자동차의 쌍 수를 반환합니다.
     * (0, 1) 을 갖는 수의 인덱스 값을 찾고 해당 갯수를 리턴
     *
     */
    fun solution(A: IntArray): Int {
        var eastCount = 0
        var answer = 0
        A.forEach {
            if (it == 0) {
                eastCount++
            }
            if (eastCount >= 1 && it == 1) {
                answer += eastCount
            }
            if (answer > 1000000000) {
                return -1
            }
        }
        return answer
    }
}