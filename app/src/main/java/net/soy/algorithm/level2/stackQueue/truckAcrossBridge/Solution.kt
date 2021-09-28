package net.soy.algorithm.level2.stackQueue.truckAcrossBridge

import java.util.*

/**
 * Class: Solution
 * Created by leesoyoung on 2020/06/09.
 *
 * Description: 프로그래머스 코딩테스트 연습 level2 스택/큐 "다리를 지나는 트럭" 문제
 */
class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {

        val outsideTruck = LinkedList<Int>()    // 바깥에서 대기하고 있는 트럭
        val insideTruck = ArrayList<Truck>()    // 다리 안에서 이동중인 트럭

        //트럭의 무게를 바깥에서 대기중인 트럭 리스트에 다 넣어 준다
        truck_weights.forEach {
            outsideTruck.add(it)
        }

        var totalWeight: Int = outsideTruck.peek()  // 현재 다리 위 무게 -> 대기중인 트럭중 첫번째 트럭의 무게를 더해준다.

        var time = 0    //이동시간

        //대기중인 트럭중 첫 번째 트럭을 다리 위 이동중인 트럭 리스트에 넣어준다, 위치 = 0
        insideTruck.add(Truck(outsideTruck.poll(), 0))

        while (insideTruck.isNotEmpty()) {   //다리 위 이동중인 트럭 리스트가 있을동안만 진행
            time++  //이동 시간을 하나씩 더해준다.

            // 다리 위 이동중인 트럭 리스트의 위치 값을 하나씩 증가 시켜준다.
            insideTruck.forEach {
                it.index++
            }

            //  다리 위 이동중인 트럭이 끝까지 갔을 경우
            //  전체 무게에서 해당 트럭의 무게를 빼주고,
            //  다리 위 이동중인 트럭 리스트에서 해당 데이터를 지운다
            if (insideTruck[0].index > bridge_length) {
                totalWeight -= insideTruck[0].weight
                insideTruck.removeAt(0)
            }

            // 대기중인 트럭이 있고
            // 다리 위 전체 무게 + 대기중인 트럭중 첫번째 트럭의 무게가 다리라 견딜수 있는 무게 보다 적을 경우
            if (outsideTruck.isNotEmpty() && totalWeight + outsideTruck.peek() <= weight) {
                val nextTruck =
                    outsideTruck.poll() //  대기중인 트럭중 첫번째 트럭을 총 무게에 더하고 이동중인 트럭 리스트에 넣어준다
                totalWeight += nextTruck
                insideTruck.add(Truck(nextTruck, 1))
            }

        }
        return time
    }

    data class Truck(
        var weight: Int,    //트럭의 무게
        var index: Int  //다리 위 트럭의 위치
    )
}