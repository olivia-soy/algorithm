package net.soy.algorithm.level1.kakaointern.keypad

/**
 * Class: Solution
 * Created by leesoyoung on 2021/05/17.
 *
 * Description: 프로그래머스 코딩테스트 연습 2020 카카오 인턴십 키패드 누르기
 *
 * 두 점사이의 거리를 구하는 문제가 아닌건가?
 * hypot 를 사용하는게 아니고 abs를 통해 절대 값을 구하는 문제 이다 왜징?...
 *
 * ypot -> 2차원 좌표상 두점 사이 거리를  구할 때 사용되는 함수
 *
 * ((this.first - pair.first)제곱  + (this.second - pair.second)제곱)의 제곱근
 *
 */
class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        val leftArray = intArrayOf(1, 4, 7)
        val rightArray = intArrayOf(3, 6, 9)
        var leftPosition: Any = "*"
        var rightPosition: Any = "#"

        val array = intArrayOf(1, 2, 3)
        numbers.forEach {
            when {
                leftArray.contains(it) -> {
                    answer += "L"
                    leftPosition = it
                }
                rightArray.contains(it) -> {
                    answer += "R"
                    rightPosition = it
                }
                else -> {
                    val numLocation = it.convertToLocation()
                    val leftDistance = leftPosition.convertToLocation().distance(numLocation)
                    val rightDistance = rightPosition.convertToLocation().distance(numLocation)
                    when {
                        leftDistance > rightDistance -> {
                            answer += "R"
                            rightPosition = it
                        }
                        leftDistance < rightDistance -> {
                            answer += "L"
                            leftPosition = it
                        }
                        leftDistance == rightDistance -> {
                            when (hand) {
                                "left" -> {
                                    answer += "L"
                                    leftPosition = it
                                }
                                else -> {
                                    answer += "R"
                                    rightPosition = it
                                }
                            }
                        }
                    }
                }
            }
        }
        return answer
    }

    /**
     * 키패트를 좌표로 변환
     */
    private fun Any.convertToLocation(): Pair<Int, Int> {
        return when (this) {
            1 -> Pair(0, 3)
            2 -> Pair(1, 3)
            3 -> Pair(2, 3)
            4 -> Pair(0, 2)
            5 -> Pair(1, 2)
            6 -> Pair(2, 2)
            7 -> Pair(0, 1)
            8 -> Pair(1, 1)
            9 -> Pair(2, 1)
            "*" -> Pair(0, 0)
            0 -> Pair(1, 0)
            "#" -> Pair(2, 0)
            else -> Pair(-1, -1)
        }
    }

    /**
     * 절대값을 구함
     */
    private fun Pair<Int, Int>.distance(pair: Pair<Int, Int>): Int {
        return kotlin.math.abs(this.first - pair.first) + kotlin.math.abs(this.second - pair.second)
    }
}