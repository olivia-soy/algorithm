package net.soy.algorithm.codility.stacksandqueues

/**
 * Algorithm
 * 지정된 괄호 문자열(단일 유형)이 올바르게 중첩되어 있는지 여부를 확인
 * @author leesoyoung
 * @since 2022/05/08
 */

class Nesting {
	fun solution(S: String): Int {
		val stack = arrayListOf<Char>()
		S.forEach {
			if (it == '(') {
				stack.add(it)
			} else {
				if (stack.isEmpty()) {
					return 0
				} else {
					stack.removeAt(stack.size - 1)
				}
			}
		}

		return if (stack.isEmpty()) 1 else 0
	}
}