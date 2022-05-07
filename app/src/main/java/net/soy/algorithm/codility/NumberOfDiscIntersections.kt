package net.soy.algorithm.codility

/**
 * Algorithm
 * 일련의 디스크에서 교차점 수를 계산합니다.
 * @author leesoyoung
 * @since 2022/05/07
 */

class NumberOfDiscIntersections {
	/**
	A[0] = 1
	A[1] = 5
	A[2] = 2
	A[3] = 1
	A[4] = 4
	A[5] = 0
	 */
	//62% The following issues have been detected: wrong answers, timeout errors.
	//For example, for the input [1, 2147483647, 0] the solution returned a wrong answer (got 0 expected 2).
	fun solution1(A: IntArray): Int {
		var answer = 0
		val sortedA = A.mapIndexed { index, i ->
			Pair(index - i, index + i)
		}.sortedBy { it.first }
		sortedA.forEachIndexed { index, pair ->
			println(pair)
			for (i in index + 1 until A.size) {
				if (pair.first <= sortedA[i].first && pair.second >= sortedA[i].first) {
					println("pair : $pair, sortedA[$i] :${sortedA[i]}")
					answer += 1
				}
			}
		}

		return if (answer > 10000000) -1 else answer
	}

	//81% time out ....
	//The following issues have been detected: timeout errors.
	fun solution(A: IntArray): Int {
		var answer = 0
		val sortedA = A.mapIndexed { index, i ->
			Pair(index - i.toLong(), index + i.toLong())    //Int.MAX_VALUE 대응
		}.sortedBy { it.first }


		sortedA.forEachIndexed { index, pair ->
			for (i in index + 1 until A.size) {
				if (answer > 10000000)
					return -1

				//겹치지 않는 경우 확인
				if (pair.second < sortedA[i].first) {
					break
				}

				if (pair.first <= sortedA[i].first && pair.second >= sortedA[i].first) {
					answer += 1
				}
			}
		}
		return answer
	}
}