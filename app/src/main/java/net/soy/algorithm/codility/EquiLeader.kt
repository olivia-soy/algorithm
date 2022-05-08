package net.soy.algorithm.codility

import java.util.*

/**
 * Algorithm
 * A[0], A[1], ..., A[S]와 A[S+1], A[S+2], ..., A[N - 1] 수열의 선두가 같도록 지수 S를 구한다.
 * @author leesoyoung
 * @since 2022/05/08
 */

class EquiLeader {

	/**
	 * N개의 정수로 구성된 비어있지 않은 배열 A가 주어졌을 때, equi 리더의 수를 반환한다.
	 *
	 * equi leader는 0 ≤ S < N ≤ 1이고
	 * 두 시퀀스 A[0], A[1], ..., A[S] 및 A[S + 1], A[S + 2], ..., A[N ≤ 1]가 같은 값의 leader를 갖도록 하는 인덱스 S이다.
	 */
	//55% timeout error 각 구간에 equi 리더가 하나씩 올 수 밖에 없는거 학인하기
	fun solution(A: IntArray): Int {
		var answer = 0
		val startMap = TreeMap<Int, Int>()
		val endMap = TreeMap<Int, Int>()
		A.forEach {
			if (endMap[it] != null) {
				endMap[it] = endMap[it]!! + 1
			} else {
				endMap[it] = 1
			}
		}

		A.forEachIndexed { index, i ->
			if (startMap[i] != null) {
				startMap[i] = startMap[i]!! + 1
			} else {
				startMap[i] = 1
			}

			if (endMap[A[index]] != null) {
				endMap[A[index]] = endMap[A[index]]!! - 1
				if (endMap[A[index]] == 0) {
					endMap.remove(A[index])
				}
			}

			val startCount = startMap.filter {
				it.value > (index + 1).div(2)
			}

			println("startCount $startCount")
			val endCount = endMap.filter {
				it.value > (A.size - (index + 1)).div(2)
			}

			println("endCount $endCount")

			if (startCount.isNotEmpty() && endCount.isNotEmpty() && startCount.keys.first() == endCount.keys.first()) {
				answer++
			}
		}

		return answer
	}

}