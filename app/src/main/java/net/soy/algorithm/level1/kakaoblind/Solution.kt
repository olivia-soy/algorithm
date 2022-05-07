package net.soy.algorithm.level1.kakaoblind

/**
 * Class: Solution
 * Created by leesoyoung on 2020/06/09.
 *
 * Description: 프로그래머스 2022 KAKAO BLIND RECRUITMENT "신고 결과 받기" 문제
 */
class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = intArrayOf()

        val new = report.map {
            it.split(" ")
        }.groupBy {
            it[1]
        }
        return answer
    }
}