package net.soy.algorithm.level1.monthlycodechallenge.season2.plusminus

/**
 * Class: Solution
 * Created by leesoyoung on 2021/05/16.
 *
 * Description: 프로그래머스 코딩테스트 연습 월간챌린지 시즌2 음양더하기 문제
 *
 */
class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var answer: Int = 0
        signs.forEachIndexed { index, _ ->
            answer += if(signs[index]){
                absolutes[index]
            } else {
                (absolutes[index] * -1)
            }
        }
        return answer
    }
}