package net.soy.algorithm.level1.greedy.gymsuit

/**
 * 코딩테스트 연습 > 탐욕법(Greedy) >체육복
 *
 * @author LEESOYOUNG
 * @since 2021-08-24
 */
class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        //lost 와 reserve 의 중복 멤버 추출
        val duplicatedList = lost.filter {
            it in reserve
        }

        val reserveArrayList = arrayListOf<Int>()
        reserveArrayList.addAll(reserve.toList())
        reserveArrayList.removeAll(duplicatedList)

        val lostArrayList = arrayListOf<Int>()
        lostArrayList.addAll(lost.toList())
        lostArrayList.removeAll(duplicatedList)

        val newArrayList = arrayListOf<Int>()

        //오름차순 정렬 후 진행
        lostArrayList.sort()
        lostArrayList.forEach {
            when {
                it.dec() in reserveArrayList -> {
                    newArrayList.add(it)
                    reserveArrayList.remove(it.dec())
                }
                it.inc() in reserveArrayList -> {
                    newArrayList.add(it)
                    reserveArrayList.remove(it.inc())
                }
            }
        }

        return n - (lostArrayList.size - newArrayList.distinct().size)
    }
}