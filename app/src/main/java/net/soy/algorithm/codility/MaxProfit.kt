package net.soy.algorithm.codility

/**
 * Algorithm
 * Maximum slice problem
 * @author leesoyoung
 * @since 2022/05/08
 */

class MaxProfit {
	/**
	 * A가 N일 연속 기간 동안 주식의 일일 가격을 포함하는 N개의 정수로 구성된 경우,
	 * 이 기간 동안 한 거래에서 가능한 최대 이익을 반환한다.
	 * 이 함수는 이익을 얻을 수 없는 경우 0을 반환해야 합니다.
	 */
	//88%
	fun solution1(A: IntArray): Int {
		if (A.isEmpty() || A.size == 1)
			return 0
		var min = Pair(A[0], 0)
		var max = Pair(A[A.size - 1], A.size - 1)

		A.forEachIndexed { index, i ->
			println("index : $index")
			if (i < min.first && index < max.second) {
				min = Pair(i, index)
				println("min : $min")
			}

			val maxIndex = A.size - 1 - index
			println("maxIndex : $maxIndex")
			if (A[maxIndex] > max.first && maxIndex > min.second) {
				max = Pair(A[maxIndex], maxIndex)
				println("max : $max")
			}
		}

		return if (min.second >= max.second || max.first - min.first < 0) 0 else max.first - min.first
	}

	fun solution(A: IntArray): Int {
		if (A.isEmpty() || A.size == 1)
			return 0

		var min = A[0]
		var answer = 0
		A.forEach { i ->
			if (i < min) {
				min = i
			}

			if (i - min > 0 && answer < i - min) {
				answer = i - min
			}
		}

		return answer
	}

}