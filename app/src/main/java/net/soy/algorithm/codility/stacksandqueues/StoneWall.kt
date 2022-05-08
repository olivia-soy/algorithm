package net.soy.algorithm.codility.stacksandqueues

/**
 * Algorithm
 * 최소 직사각형 수를 사용하여 "맨해튼 스카이라인"을 덮으십시오.
 * @author leesoyoung
 * @since 2022/05/08
 */

class StoneWall {

	fun solution(H: IntArray): Int {
		val stack = arrayListOf<Int>()
		var answer = 0
		stack.add(H[0])
		for (i in 1 until H.size) {
			while (stack.isNotEmpty()) {
				val height = stack[stack.size - 1]
				/**
				 * 1. 이전 높이와 같으면 패스
				 * 2. 이전 높이보다 낮으면 count 추가 이전 stack pop
				 * 3. 이전 높이보다 높으면 stack push
				 */
				if (height > H[i]) {
					answer++
					stack.removeAt(stack.size - 1)
				}
				if (height < H[i]) {
					stack.add(H[i])
					break
				}
				if (height == H[i]) {
					break
				}
			}
			if (stack.isEmpty()) {
				stack.add(H[i])
			}
		}

		return answer + stack.size
	}

}