package net.soy.algorithm.codility

/**
 * # Algorithm
 * # 양의 정수 N이 주어지면 가장 긴 이진 간격의 길이를 반환한다. N에 이항 간격이 없으면 함수는 0을 반환해야 합니다.
 * @author LEESOYOUNG
 * @since 2022-03-07
 */
class BinaryGap {
    /**
     */
    fun solution(N: Int): Int {
        val onePoint = arrayListOf<Int>()
        val gap = arrayListOf<Int>()

        Integer.toBinaryString(N).toCharArray().forEachIndexed { index, c ->
            if (c == '1') {
                onePoint.add(index)
            }
        }

        if (onePoint.size == 1) {
            return 0
        }

        onePoint.reversed().forEachIndexed { index, i ->
            if (index + 1 < onePoint.size) {
                gap.add((i - onePoint.reversed()[index + 1]).dec())
            }
        }

        var max = Int.MIN_VALUE
        for (i in 0 until gap.size) {
            if (gap[i] > max) {
                max = gap[i]
            }
        }
        return max
    }
}

