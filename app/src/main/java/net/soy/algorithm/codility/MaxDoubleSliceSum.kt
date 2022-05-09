package net.soy.algorithm.codility

import kotlin.math.max

/**
 * Algorithm
 *
 * @author leesoyoung
 * @since 2022/05/09
 */

class MaxDoubleSliceSum {
	//30% -> Y기준으로 앞뒤의 최대값을 구해서 더해주는 방법 검토 필요
	fun solution(A: IntArray): Int {
		if (A.size == 3) {
			return 0
		}
		var max = A[1]
		var sum = A[1]
		var min = Int.MAX_VALUE
		//3, 2, 6, -1, 4, 5, -1, 2
		for (i in 2 until A.size - 1) {
			//현재 값이 합계보다 클 경우 현재 값부터 다시 더하기
			sum = max(A[i], A[i] + sum)
			if (A[i] < min) {
				min = A[i]
			}
			if (sum > max) {
				max = sum
			}
		}

		return max - min
	}
}
