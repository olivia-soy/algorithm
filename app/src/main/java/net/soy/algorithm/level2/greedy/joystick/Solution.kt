package net.soy.algorithm.level2.greedy.joystick

import java.util.*
import kotlin.math.min

/**
 * Class: Solution
 * Created by leesoyoung on 2020/06/03.
 *
 * Description: 프로그래머스 코딩테스트 연습 level2 탐욕법 "조이스틱" 문제
 *
 * JAN
 */
class Solution {
    fun solution(name: String): Int {
        var answer = 0

        // A에 가까운 알파벳일 경우 A -> B -> C 순으로 이동 = it - A
        // Z에 가까운 알파벳일 경우 A -> Z -> Y 순으로 이동 = Z - it + 1
        val charArray = name.toCharArray()
        var min = charArray.size - 1

        charArray.forEachIndexed { index, c ->
            answer += min((c - 'A'), ('Z' - c + 1))

            var nextIndex = index + 1
            while (nextIndex < name.length && name[nextIndex] == 'A')
                nextIndex++
            min = min(min, index * 2 + name.length - nextIndex)
        }

        answer += min
        return answer
    }
}