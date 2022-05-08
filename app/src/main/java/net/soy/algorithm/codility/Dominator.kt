package net.soy.algorithm.codility

/**
 * Algorithm
 * 배열의 값이 배열의 인덱스의 절반 이상에서 발생하도록 배열의 인덱스를 찾습니다.
 * @author leesoyoung
 * @since 2022/05/08
 */

class Dominator {
	/**
	 * 배열 A에서 절반이상을 차지하는 요소의 인덱스 값중 아무값이나 리턴 EquiLeader
	 * 없을 경우 -1
	 */
	fun solution(A: IntArray): Int {
		if (A.size == 1) {    //single item
			return 0
		}
		val map = HashMap<Int, Int>()
		for (i in A.indices) {
			if (map[A[i]] != null) {
				map[A[i]] = map[A[i]]!! + 1
				if (map[A[i]]!! > A.size.div(2)) {
					return i
				}
			} else {
				map[A[i]] = 1
			}
		}
		return -1
	}

}