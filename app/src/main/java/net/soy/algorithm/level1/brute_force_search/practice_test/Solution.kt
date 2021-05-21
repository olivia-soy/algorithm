package net.soy.algorithm.level1.brute_force_search.practice_test

/**
 * Class: Solution
 * Created by leesoyoung on 2021/05/21.
 *
 * Description: 프로그래머스 코딩테스트 연습 완전탐색 모의고사
 */
class Solution {
    fun solution(answers: IntArray): IntArray {
        val firstAnswers = arrayListOf(1, 2, 3, 4, 5)
        val secondAnswers = arrayListOf(2, 1, 2, 3, 2, 4, 2, 5)
        val thirdAnswers = arrayListOf(3, 3, 1, 1, 2, 2, 4, 4,5, 5)

        val firstAnswersCount = 0
        val secondAnswersCount = 0
        val thirdAnswersCount = 0

        answers.forEachIndexed { index, answer ->
            if (answer == firstAnswers[index]) {
                firstAnswersCount.plus(1)
            }

            if (answer == secondAnswers[index]) {
                secondAnswersCount.plus(1)
            }

            if (answer == thirdAnswers[index]) {
                thirdAnswersCount.plus(1)
            }
        }
        var answer = intArrayOf(firstAnswersCount, secondAnswersCount, thirdAnswersCount)
        answer.maxOrNull()
        return answer
    }
}