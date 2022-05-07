package net.soy.algorithm.codility

import java.util.*

/**
 * Algorithm
 * DNA 염기서열에서 최소 뉴클레오티드를 찾아라.
 * @author leesoyoung
 * @since 2022/05/07
 */

class GenomicRangeQuery {
	/**
	 * DNA 염기서열에서 최소 뉴클레오티드를 찾아라.
	 *
	 * A형, C형, G형, T형 뉴클레오타이드는 각각 1, 2, 3, 4의 충격 인자를 갖는다.
	 * M은 P, S 의 사이즈
	 *
	 * 예를 들어 문자열 S = CAGCCTA 및 배열 P, Q를 다음과 같이 고려하십시오.
	 * P[0] = 2 Q[0] = 4
	 * P[1] = 5 Q[1] = 5
	 * P[2] = 0 Q[2] = 6 이 M = 3 쿼리에 대한 답은 다음과 같습니다.
	 * 위치 2와 4 사이의 DNA 부분은 뉴클레오티드 G와 C(두 번)를 포함하고 있는데,
	 * 그 영향인자는 각각 3과 2이므로 답은 2이다.
	 *
	 * 위치 5와 5 사이의 부분은 충격 계수가 4인 단일 뉴클레오타이드 T를 포함하므로 답은 4입니다.
	 *
	 * 위치 0과 6 사이의 부분 (전체 문자열)은 모든 뉴클레오타이드, 특히 충격 계수가 1 인 뉴클레오타이드 A를 포함하므로 답은 1입니다.
	 */

	//62% timeout
	fun solution(S: String, P: IntArray, Q: IntArray): IntArray {
		val answer = arrayListOf<Int>()
		P.forEachIndexed { index, i ->
			if (i == Q[index]) {
				answer.add(findImpactFacter(S[i]))
			} else {
				answer.add(findMinimal(S.substring(i..Q[index])))
			}
		}
		println(answer)
		return answer.toIntArray()
	}

	private fun findMinimal(s: String): Int {
		val treeSet = TreeSet<Char>()
		treeSet.addAll(s.toCharArray().asList())
		return findImpactFacter(treeSet.first())
	}

	private fun findImpactFacter(c: Char): Int {
		return when (c) {
			'A' -> 1
			'C' -> 2
			'G' -> 3
			else -> 4
		}
	}
}