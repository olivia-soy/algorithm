package net.soy.algorithm.codility.stacksandqueues

/**
 * Algorithm
 * 지정된 괄호 문자열(여러 유형)이 올바르게 중첩되었는지 확인
 * @author leesoyoung
 * @since 2022/05/08
 */

class Brackets {
	/**
	 * N개의 문자로 구성된 문자열 S가 주어지면 S가 제대로 중첩되면 1을 반환하고 그렇지 않으면 0을 반환합니다.
	 * 예를 들어, S = "{[()()]}일 때, 함수는 1을 반환하고 S =("()])일 때, 함수는 위에서 설명한 대로 0을 반환해야 한다.
	 */
	fun solution(S: String): Int {
		if (S.isEmpty()) {
			return 1
		}

		if (S.length.rem(2) != 0) {
			return 0
		}

		val stack = arrayListOf<Char>()
		S.forEach {
			when (it) {
				'(', '{', '[' -> {
					stack.add(it)   //push
				}
				else -> {
					if (stack.isEmpty()) {
						return 0
					}
					if (stack[stack.size - 1] == getNested(it)) {  //top
						stack.removeAt(stack.size - 1)   //pop
					} else {
						return 0
					}
				}
			}
		}

		return if (stack.isEmpty()) 1 else 0
	}

	private fun getNested(c: Char) = when (c) {
		']' -> '['
		'}' -> '{'
		else -> '('
	}
}