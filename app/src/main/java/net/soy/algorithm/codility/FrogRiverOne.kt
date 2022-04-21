package net.soy.algorithm.codility

/**
 * # Algorithm
 * # [81%] 개구리가 강 반대편으로 점프할 수 있는 가장 이른 시간을 찾아보세요.
 * @author LEESOYOUNG
 * @since 2022-04-04
 */
class FrogRiverOne {
    /**
     * 작은 개구리는 강 반대편으로 가고 싶어한다.
     * 개구리는 처음에는 강의 한 둑(위치 0)에 위치하고 있으며 반대편 둑(위치 X+1)으로 가고 싶어한다.
     * 나뭇잎이 나무에서 강 표면으로 떨어진다.
     *
     * 떨어지는 잎을 나타내는 N 개의 정수로 구성된 배열 A가 제공됩니다.
     * A [K]는 시간 K에서 한 잎이 떨어지는 위치를 나타내며 초 단위로 측정됩니다.
     *
     * 개구리가 강 건너편으로 점프할 수 있는 가장 빠른 시간을 찾는 것이 목표다.
     * 개구리는 1에서 X까지 강을 가로 지르는 모든 위치에 잎이 나타날 때만 교차 할 수 있습니다
     * (즉, 1에서 X까지의 모든 위치가 잎으로 덮여있는 가장 빠른 순간을 찾고 싶습니다).
     * 강물의 흐름 속도가 무시할 정도로 작다고 가정할 수 있습니다.
     * 나뭇잎은 강에 떨어지면 위치를 바꾸지 않는다.
     */
    fun solution(X: Int, A: IntArray): Int {
        // write your code in Kotlin 1.3.11 (Linux)
        val answerList: HashSet<Int> = hashSetOf()
        var answer = -1

        for(i in A.indices){
            answerList.add(A[i])
            if(answerList.size == X){
                return i
            }
        }
        return answer
    }
}