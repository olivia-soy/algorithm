package net.soy.algorithm.level1.exercise.nNumbersSpacedByX

/**
 * Algorithm
 * 코딩테스트 연습 > 연습 문제 > x만큼 간격이 있는 n개의 숫자
 * @author LEESOYOUNG
 * @since 2021-09-14
 */
class Solution {
    fun solution(x: Int, n: Int): LongArray {
        val answer = LongArray(n)
        for(i in 0 until n){
            answer[i] = x.toLong().times(i + 1)
        }
        return answer
    }
}