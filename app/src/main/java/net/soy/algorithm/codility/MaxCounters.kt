package net.soy.algorithm.codility

/**
 * # Algorithm
 * # Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum.
 * @author LEESOYOUNG
 * @since 2022-04-12
 */
class MaxCounters {
    /**
     * 처음에는 0으로 설정된 N개의 카운터가 제공되며 다음 두 가지 작업을 수행할 수 있습니다.

    증가(X) - 카운터 X가 1만큼 증가합니다.
    max counter - 모든 카운터가 카운터의 최대값으로 설정됩니다.
    비어 있지 않은 정수 배열 A가 주어집니다. 이 배열은 연속 작업을 나타냅니다.

    A[K] = X, 즉 1 ≤ X ≤ N이면, 연산 K는 증가(X),
    A[K] = N + 1이면 연산 K는 최대 카운터입니다.
    예를 들어, 다음과 같은 정수 N = 5와 배열 A가 주어지면,

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
    연속 작업 후 카운터 값은 다음과 같습니다.

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
    목표는 모든 작동 후 모든 카운터의 값을 계산하는 것입니다.

    함수 쓰기:

    재미있는 솔루션(N: Int, A: IntArray): 인트어레이

    정수 N과 정수로 구성된 비어 있지 않은 배열 A가 주어지면 카운터의 값을 나타내는 정수 시퀀스를 반환합니다.

    결과 배열을 정수 배열로 반환해야 합니다.

    예를 들어 다음과 같다.

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
    함수는 위에서 설명한 대로 [3, 2, 2, 4, 2]를 반환해야 합니다.

    다음 가정을 위한 효율적인 알고리즘을 작성합니다.
     */
    fun solution(N: Int, A: IntArray): IntArray {
        var answerList = IntArray(N)
        A.forEach {
            if (it <= N) {
                answerList[it - 1] = answerList[it - 1].inc()
            } else {
                val max = answerList.maxOrNull()!!
                answerList = IntArray(N) {
                    max
                }
            }
        }
        return answerList
    }
}