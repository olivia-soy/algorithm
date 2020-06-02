package net.soy.algorithm.level2.sort.max

/**
 * Class: Solution
 * Created by leesoyoung on 2020/06/01.
 *
 * Description: 프로그래머스 코딩테스트 연습 level2 정렬 "가장 큰 수" 문제
 */
class Solution {
    fun solution(numbers: IntArray): String {
        val strings = arrayListOf<String>()

        numbers.forEach {
            strings.add(it.toString())
        }

        /**
         * 첫번째 + 두번째 와 두번째 + 첫번째 값을 비교하여 큰순서대로 정렬
         * 기본 오름차순으로 나오기 때문에 매개변수 순서를 변경하여 내림차순으로 나올수 있도록 한다.
         */
        strings.sortWith(Comparator { t, t2 -> (t2 + t).compareTo(t + t2) })

        /**
         * "0" 으로 시작할 경우 "0000"이므로 "0" 만 리턴하도록 변경
         */
        return if (strings.first() == "0") {
            "0"
        } else {
            var answer = ""
            strings.forEach {
                answer += it
            }
            answer
        }

    }
}