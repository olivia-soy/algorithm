package net.soy.algorithm.monthlycodechallenge.season1.internal

/**
 * Class: Solution
 * Created by leesoyoung on 2021/05/11.
 *
 * Description: 프로그래머스 코딩테스트 연습 월간챌린지 시즌1 내적 문제
 */
class Solution {
    fun solution(a: IntArray, b: IntArray): Int {
        var answer = 0
        a.forEachIndexed { aIndex, _ ->
            answer += a[aIndex] * b[aIndex]
        }
        return answer

        //return a.zip(b).map { it.first * it.second }.sum()
    }
}