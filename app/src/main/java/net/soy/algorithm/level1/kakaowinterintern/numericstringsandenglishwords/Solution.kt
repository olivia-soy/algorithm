package net.soy.algorithm.level1.kakaowinterintern.numericstringsandenglishwords

/**
 * 코딩테스트 연습 2021 카카오 채용연계형 인턴십 숫자 문자열과 영단어
 *
 * @author LEESOYOUNG
 * @since 2021-08-18
 */
class Solution {
    fun solution(s: String): Int {
        val sb = StringBuffer(s)

        val result = sb.filter {
            it in 'a'..'z' || it in '0'..'9' || it == '-' || it == '_' || it == '.'
        }.map {

        }
        var answer: Int = 0
        return answer
    }

    fun strToNum(strNum: String): Int{
        return when(strNum){
            "zero" -> 0
            "one" -> 1
            "two" -> 2
            "three" -> 3
            "four" -> 4
            "five" -> 5
            "siz" ->  6
            "seven" -> 7
            "eight" -> 8
            "nine" -> 9
            else -> 0
        }
    }
}