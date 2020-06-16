package net.soy.algorithm.level1.skilltest.one

/**
 * Class: Solution
 * Created by leesoyoung on 2020/06/16.
 *
 * Description: 프로그래머스 코딩테스트 연습 level1 스킬 테스트
 */
class Solution {
    fun solution(n: Long): IntArray {
        var strN = n.toString().toCharArray()

        strN.reverse()

        strN.toString()

        var answer = arrayListOf<Int>()
        strN.forEach {
            answer.add(it.toString().toInt())
        }

        return answer.toIntArray()
    }
}