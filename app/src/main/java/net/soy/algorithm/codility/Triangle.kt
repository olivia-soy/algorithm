package net.soy.algorithm.codility

/**
 * Algorithm
 * 주어진 모서리 집합에서 삼각형을 만들 수 있는지 여부를 확인합니다.
 * @author leesoyoung
 * @since 2022/05/07
 */

class Triangle {
	/**
	 * N개의 정수로 구성된 배열 A가 이 배열에 대해 삼각형 삼중항이 존재하면 1을 반환하고 그렇지 않으면 0을 반환한다.
	 *
	 * 삼각형 특징
	 * A[P] + A[Q] > A[R],
	 * A[Q] + A[R] > A[P],
	 * A[R] + A[P] > A[Q].
	 *
	 */
	//93% extreme_arith_overflow1 overflow test, 3 MAXINTs
	fun solution1(A: IntArray): Int {
		if (A.size < 2 || A.isEmpty()) {
			return 0
		}
		val sortedA = A.sorted()

		for (i in 2 until sortedA.size) {
			if ((sortedA[i - 2] + sortedA[i - 1]) > sortedA[i]
				&& (sortedA[i - 1] + sortedA[i]) > sortedA[i - 2]
				&& (sortedA[i - 2] + sortedA[i]) > sortedA[i - 1]
			) {
				return 1
			}
		}
		return 0
	}

	/**
	 * 세 수 모두 Int.MaxValue 일 경우 두수 의 합과 다른 한 수의 합의 값이 같으므로 0 리턴
	 *
	 * Int 보다 범위가 넓은 Long 으로 변환하여 계산 진행
	 */
	fun solution(A: IntArray): Int {
		if (A.size < 2 || A.isEmpty()) {
			return 0
		}
		val sortedA = A.sorted()

		for (i in 2 until sortedA.size) {
			if ((sortedA[i - 2].toLong() + sortedA[i - 1].toLong()) > sortedA[i].toLong()
				&& (sortedA[i - 1].toLong() + sortedA[i].toLong()) > sortedA[i - 2].toLong()
				&& (sortedA[i - 2].toLong() + sortedA[i].toLong()) > sortedA[i - 1].toLong()
			) {
				return 1
			}
		}
		return 0
	}
}