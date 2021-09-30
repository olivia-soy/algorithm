package net.soy.algorithm.level1.monthlycodechallenge.season3.notIncludedNum

/**
 * Algorithm
 * 코딩테스트 연습 > 월간 코드 챌린지 시즌3 > 없는 숫자 구하기
 * @author LEESOYOUNG
 * @since 2021-09-30
 */
class Solution {
    fun solution(numbers: IntArray): Int {
        return intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).filter { it !in numbers }.sum()
    }
}