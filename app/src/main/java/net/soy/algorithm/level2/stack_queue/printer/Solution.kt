package net.soy.algorithm.level2.stack_queue.printer

import java.util.*

/**
 * Class: printer
 * Created by leesoyoung on 2020/06/01.
 *
 * Description: 프로그래머스 코딩테스트 연습 level2 스택/큐 "프린터" 문제
 */
class Solution {

    companion object{
        lateinit var queue : Queue<Printer>

        /**
         * @param num 큐 가장 앞에 있던 데이터의 우선순위
         * @return
         * num 보다 우선순위가 높은 데이터 존재할 경우 true
         * 존재하지 않을 경우 false
         */
        fun check(num: Int): Boolean{
            var flag = false


            val checkList = queue.toTypedArray()

            for(i in queue.indices){
                if(checkList[i].priority > num){
                    flag = true
                    break
                }
            }
            return flag
        }
    }

    fun solution(priorities: IntArray, location: Int): Int {
        var answerList = arrayOfNulls<Int>(priorities.size)
        var answer = 0
        queue = LinkedList()

        // queue 에 삽입
        for(i in priorities.indices){
            queue.offer(Printer(priorities[i], i))
        }

        var j = 0
        while (!queue.isEmpty()){
            //1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
            val printer = queue.poll()
            val priority: Int = printer.priority

            //2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
            if(check(priority)){
                queue.offer(printer)
            //3. 그렇지 않으면 J를 인쇄합니다. (내가 인쇄 요청한 문서가 몇번째인지 알기 위해서 정답 리스트에 넣은뒤 다시 비교 작업을 해야함)
            } else {
                answerList[j] = printer.index
                j++
            }
        }


        for(i in answerList.indices){
            //내가 인쇄 요청한 문서의 위치 (location) 와 같을 경우 answer 값 리턴
            // 응답 값을 location 값에서 + 1 해준다
            if(answerList[i] == location){
                answer = i + 1
                break
            }
        }

        return answer
    }

    /**
     * 우선순위와 인덱스 값으로 구성된 Printer 클래스
     */
    data class Printer(
        val priority: Int,
        val index: Int
    )


}