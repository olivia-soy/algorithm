package net.soy.algorithm.level1.exercise.bruteForceSearch

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
        val thirdAnswers = arrayListOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        var firstAnswersCount = 0
        var secondAnswersCount = 0
        var thirdAnswersCount = 0


        answers.forEachIndexed { index, answer ->
            if (firstAnswers[index % firstAnswers.size] == answers[index]) {
                firstAnswersCount += 1
            }

            if (secondAnswers[index % secondAnswers.size] == answers[index]) {
                secondAnswersCount += 1
            }

            if (thirdAnswers[index % thirdAnswers.size] == answers[index]) {
                thirdAnswersCount += 1
            }
        }


        val answerList = intArrayOf(firstAnswersCount, secondAnswersCount, thirdAnswersCount)
        var max = answerList[0]
        for (i in 1..answerList.lastIndex) {
            val e = answerList[i]
            if (max < e) max = e
        }

        val answer = arrayListOf<Int>()
        if(max == firstAnswersCount){
            answer.add(1)
        }

        if(max == secondAnswersCount){
            answer.add(2)
        }

        if(max == thirdAnswersCount){
            answer.add(3)
        }

        return answer.toIntArray()
    }
}