package net.soy.algorithm.codility

import java.util.*

/**
 * Algorithm
 * 임의의 삼중항(P, Q, R)에 대해 A[P] * A[Q] * A[R]를 최대화합니다.
 * @author leesoyoung
 * @since 2022/05/07
 */

class MaxProductOfThree {
	/**
	 * 비어있지 않은 배열 A가 주어졌을 때, 어떤 삼중항들의 최대 곱의 값을 반환한다.
	 *  A[0] = -3
	 *  A[1] = 1
	 *  A[2] = 2
	 *  A[3] = -2
	 *  A[4] = 5
	 *  A[5] = 6
	 * 함수는 삼중 항 (2, 4, 5)의 곱이 최대이므로 60을 반환해야합니다.
	 *
	 * 경우의 수
	 * 1. 모두 음수인 경우
	 * 2. 두개만 양수 나머지 모두 음수인 경우
	 * 3. 나머지 경우
	 */
	fun solution(A: IntArray): Int {
		val sortedA = A.sortedDescending()
		var answer = sortedA[0] * sortedA[1] * sortedA[2]

		if (answer < 0) {
			if (sortedA[0] > 0) {//양수 2개 나머지 음수인 경우
				answer = sortedA[2] * sortedA[A.size - 2] * sortedA[A.size - 1]
			} else { //모두 음수인 경우
				return answer
			}
		}

		if (sortedA[1] * sortedA[2] < sortedA[A.size - 2] * sortedA[A.size - 1]) {
			answer = sortedA[0] * sortedA[A.size - 2] * sortedA[A.size - 1]
		}

		return answer
	}
}