package net.soy.algorithm.codility

import kotlin.math.max

/**
 * Algorithm
 * N개의 정수로 구성된 배열 A가 주어졌을 때, A의 어떤 조각의 최대 합을 반환
 * @author leesoyoung
 * @since 2022/05/09
 */

class MaxSliceSum {

	//%61 timeout
	fun solution1(A: IntArray): Int {
		var max = Long.MIN_VALUE
		if (A.size == 1) {
			return A.first()
		}
		for (i in 1 until A.size) {
			var sum = A[i]
			if (max < sum) {
				max = sum.toLong()
			}
			for (j in i + 1 until A.size) {
				sum = A.slice(i..j).sum()
				println(sum)
				if (max < sum) {
					max = sum.toLong()
				}
			}
		}
		return max.toInt()
	}

	fun solution(A: IntArray): Int {
		var max = A[0]
		var sum = A[0]
		for (i in 1 until A.size) {
			//현재 값이 합계보다 클 경우 현재 값부터 다시 더하기
			sum = max(A[i], A[i] + sum)
			if (sum > max) {
				max = sum
			}
		}
		return max
	}

}