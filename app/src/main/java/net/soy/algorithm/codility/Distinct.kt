package net.soy.algorithm.codility

/**
 * # Algorithm
 * # Distinct
 * @author LEESOYOUNG
 * @since 2022-04-22
 */
class Distinct {
    /**
     * N 개의 정수로 구성된 배열 A가 주어지면 배열 A의 고유한 값 수를 반환합니다.
     * 예를 들어, 다음과 같은 여섯 개의 요소로 구성된 배열 A가 주어지면
     * A[0] = 2 A[1] = 1 A[2] = 1 A[3] = 2 A[4] = 3 A[5] = 1 배열 A에는 3개의 뚜렷한 값, 즉 1, 2, 3이 나타나기 때문에 함수는 3을 반환해야 한다.
     */
    fun solution(A: IntArray): Int {
       return A.distinct().count()
    }
}