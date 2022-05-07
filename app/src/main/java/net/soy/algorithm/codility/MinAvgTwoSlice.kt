package net.soy.algorithm.codility

/**
 * Algorithm
 * MinAvgTwoSlice
 * @author leesoyoung
 * @since 2022/05/07
 */

class MinAvgTwoSlice {
	/**
	 * slice 구간의 합의 평균의 최솟값 찾기
	 *
	 * 1. -> timeout 60%
	 *
	 * 2. -> 수학적 풀이 필요
	 * 양수 -> 값 두개의 구간이 제일 작은 값
	 * 음수 -> 값 세개의 구간도 제일 작은 값일 수 있음
	 *
	 */
	fun solution1(A: IntArray): Int {
		var minValue = Double.MAX_VALUE
		var answer = 0
		//-3, -5, -8, -4, -10
		A.forEachIndexed { index, i ->
			println("index : $index, i : $i")
			var sum = A[index]
			(index + 1 until A.size).forEach {
				sum += A[it]
				val average = sum / (it - index + 1).toDouble()
				println("average: $average, it: $it, sum : $sum")
				if (minValue > average) {
					minValue = average
					answer = index
				}
			}
		}
		return answer
	}

	fun solution(A: IntArray): Int {
		var minValue = (A[0] + A[1]) / 2.toDouble() //값이 같을때 가장 작은 index 리턴이므로
		var answer = 0
		for (i in 0 until A.size - 1) {
			var average = (A[i] + A[i + 1]) / 2.toDouble()
			if (minValue > average) {
				minValue = average
				answer = i
			}

			if (i + 2 < A.size) {
				average = (A[i] + A[i + 1] + A[i + 2]) / 3.toDouble()

				if (minValue > average) {
					minValue = average
					answer = i
				}
			}
		}
		return answer
	}
}