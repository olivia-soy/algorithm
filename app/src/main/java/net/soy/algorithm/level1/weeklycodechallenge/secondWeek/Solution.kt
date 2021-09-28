package net.soy.algorithm.level1.weeklycodechallenge.secondWeek

import java.util.*

/**
 * 코딩테스트 연습 > 위클리 챌린지 > 2주차
 *
 * @author LEESOYOUNG
 * @since 2021-08-25
 */
class Solution {
    fun solution(scores: Array<IntArray>): String {
        val length = scores.size
        val subLength = scores.first().size
        val myScore: Array<Array<Int>> = Array(subLength) { Array(length) { 1 } }


        //내가 받은 점수 저장
        for (i in 0 until length) {
            for (j in 0 until subLength) {
                myScore[i][j] = scores[j][i]
            }
        }

        var answer = ""
        myScore.forEachIndexed { index, ints ->
            var flag = false
            var sum = ints.sum()

            //내가 나에게 준 점수
            val toMy = myScore[index][index]

            /**
             * Array 정렬
             * 첫번째 원소 -> 최소값
             * 마지막 원소 -> 최대값
             */
            Arrays.sort(ints)
            if (toMy >= ints[ints.size - 1] || toMy <= ints[0]) {
                // 내가 나에제 준 점수와 같은 값이 있는지 확인
                if (ints.filter { it == toMy }.size == 1) {
                    flag = true
                    sum -= toMy
                }
            }

            /**
             * flag
             * true -> 내가 나에게 준 점수 제거된 상태
             * false -> sum 에 변화가 없는 상태
             */
            answer += checkScore(sum.div(if (flag) ints.size - 1 else ints.size))
        }

        return answer
    }


    private fun checkScore(score: Int): String {
        println("score : $score")
        return when (score) {
            in 0 until 50 -> "F"
            in 50 until 70 -> "D"
            in 70 until 80 -> "C"
            in 80 until 90 -> "B"
            else -> "A"
        }
    }
}