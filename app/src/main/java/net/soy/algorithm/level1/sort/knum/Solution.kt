package net.soy.algorithm.level1.sort.knum

/**
 * Class: Solution
 * Created by leesoyoung on 2021/05/16.
 *
 * Description: 프로그래머스 코딩테스트 연습 정렬 K 번째 수 문제
 *
 */
class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = IntArray(commands.size)
        commands.forEachIndexed { index, ints ->
            answer[index] = if (ints.first() != ints[1]) {
                array.slice((ints[0] - 1) until ints[1]).sorted()[ints.last() - 1]
            } else {
                array[(ints[0] - 1)]
            }
        }
        return answer
    }
}