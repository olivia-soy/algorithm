package net.soy.algorithm.level1.skilltest.two

/**
 * Class: Solution
 * Created by leesoyoung on 2020/06/16.
 *
 * Description: 프로그래머스 코딩테스트 연습 level1 스킬 테스트
 */
class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {


        var answer = arrayListOf<Int>()


        arr.forEach {
            if(it % divisor == 0)
                answer.add(it)
        }

        answer.sort()

        return if(answer.size == 0) IntArray(-1) else answer.toIntArray()
    }
}