package net.soy.algorithm.level2.stackQueue.printer

import java.util.*

/**
 * Class: Solution
 * Created by leesoyoung on 2020/06/01.
 *
 * Description: 프로그래머스 코딩테스트 연습 level2 스택/큐 "프린터" 문제
 */
class Solution {

    companion object{
        lateinit var queue : Queue<Pair<Int, Int>>
    }

    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        queue = LinkedList()

        // queue 에 삽입
        for(i in priorities.indices){
            queue.offer(Pair(priorities[i], i))
        }

        while (!queue.isEmpty()){
            //1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
            val printer = queue.poll()

            //2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
            if(queue.any { printer.first < it.first }){
                queue.offer(printer)
            //3. 그렇지 않으면 J 를 인쇄합니다.
            } else {
                answer++
                // 내가 인쇄 요청한 문서의 위치와 현재 인덱스가 같을경우 answer 리턴함
                if(printer.second == location) return answer
            }
        }

        return answer
    }
}