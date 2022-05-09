package net.soy.algorithm.codility


import kotlin.math.sqrt

/**
 * Algorithm
 * 양의 정수 N이 주어지면 인자의 수를 반환
 * @author leesoyoung
 * @since 2022/05/09
 */

class CountFactors {
	//71%
	fun solution1(N: Int): Int {
		var answer = 0
		(1..N).forEach {
			if (N.rem(it) == 0) {
				answer++
			}
		}
		return answer
	}

	//약수의 갯수 ->
	// 1. 해당 수의 제곱근이 정수 일 경우 (제곱근의 약수의 갯수 * 2) -1
	// 2. 해당 수의 제곱근이 정수가 아닐 경우 제곱근의 약수의 갯수 * 2
	fun solution(N: Int): Int {
		var answer = 0
		if (N == 1) {
			return 1
		}
		val sqrt = sqrt(N.toDouble())
		println(sqrt)
		(1..sqrt.toInt()).forEach {
			if (N.rem(it) == 0) {
				answer++
			}
		}

		answer *= 2
		return if (sqrt - sqrt.toInt() == 0.0) answer -1 else answer
	}
}