package net.soy.algorithm.level2.stack_queue.function_development

import java.util.*

/**
 * Class: Solution
 * Created by leesoyoung on 2020/06/03.
 *
 * Description: 프로그래머스 코딩테스트 연습 level2 스택/큐 "기능개발" 문제
 */
class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val queue = LinkedList<Int>()
        progresses.forEachIndexed { index, _ ->
            var workingDays = 1
            do{
                // 남은 작업량 계산 = (전체작업량(100) - 작업 진도(progresses[index])) - (작업속도(speeds[index] * 작업일수 )
                val remainingWork = (100 - progresses[index]) - (speeds[index] * workingDays)

                // 남은 작업량이 <= 0 일경우 (작업을 완료한 경우) 작업일수 저장
                if(remainingWork <= 0)
                    queue.add(workingDays)
                workingDays++
            } while ( remainingWork > 0)
        }

        // 정답 리스트
        val answers =  arrayListOf<Int>()

        // 가장 앞에있는 작업일수를 꺼냄
        var standard: Int = queue.poll()

        // 배포될 작업 수
        var works = 1
        while (!queue.isEmpty()){
            //비교 대상이 될 큐의 작업을 꺼냄
            val comparisonTarget = queue.poll()

            // 앞에있는 작업 일수와 그 다음에 있는 작업 일수를 비교하여 앞에가 클경우 뒤에 작업이 완료되어도 기다려야 하므로 works를 하나 추가해줌
            if(standard >= comparisonTarget){
                works++
            } else {
                answers.add(works) // 다음에 있는 작업일수가 클경우 앞의 작업은 완료 후 바로 배포 가능하므로 answers 리스트에 저장
                works = 1 // 다시 1로 초기화 한다
                standard = comparisonTarget // 앞의 작업은 저장 후 끝났으므로 비교 대상이 되었던 작업을 앞에 저장
            }
        }
        answers.add(works)
        return answers.toIntArray()
    }
}