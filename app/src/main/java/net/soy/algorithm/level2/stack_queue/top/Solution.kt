package net.soy.algorithm.level2.stack_queue.top

import java.util.*

/**
 * Class: Solution
 * Created by leesoyoung on 2020/06/12.
 *
 * Description: 프로그래머스 코딩테스트 연습 level2 스택/큐 "탑" 문제
 */
class Solution {
    fun solution(heights: IntArray): IntArray {
        val queue = LinkedList<Pair<Int, Int>>()

        //.first -> 정답 리스트에 들어갈 인덱스 + 1
        //.second -> 탑의 높이
        heights.forEachIndexed { index, i ->
            queue.push(Pair(index + 1, i))
        }

        //정답을 넣을 리스트
        val answer = arrayListOf<Int>()

        //큐가 없어질 동안만 진행
        while (queue.isNotEmpty()){
            // 가장 처음에 있는 아이템을 꺼낸다
            val top = queue.pop()

            for(compare in queue){
                if(top.second < compare.second){
                    answer.add(compare.first)   //비교대상보다 높을 경우 .first 를 정답 리스트에 넣어줌
                    break
                }
            }

            // 비교대상보다 높은 아이템이 없을 경우 0을 넣는다
            if(!queue.any { top.second < it.second }){
                answer.add(0)
            }
        }

        //왼쪽부터 진행이므로 리스트를 뒤집어 준다
        answer.reverse()

        return answer.toIntArray()
    }
}