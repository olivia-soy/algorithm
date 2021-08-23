package net.soy.algorithm.level1.kakaowinterintern.numericstringsandenglishwords

/**
 * 코딩테스트 연습 2021 카카오 채용연계형 인턴십 숫자 문자열과 영단어
 *
 * @author LEESOYOUNG
 * @since 2021-08-18
 */
class Solution {
    fun solution(s: String): Int {
        var sReplaced = s
        while (sReplaced.toIntOrNull() == null) {
            sReplaced = when {
                sReplaced.contains("one") -> sReplaced.replace("one", "1")
                sReplaced.contains("two") -> sReplaced.replace("two", "2")
                sReplaced.contains("three") -> sReplaced.replace("three", "3")
                sReplaced.contains("four") -> sReplaced.replace("four", "4")
                sReplaced.contains("five") -> sReplaced.replace("five", "5")
                sReplaced.contains("six") -> sReplaced.replace("six", "6")
                sReplaced.contains("seven") -> sReplaced.replace("seven", "7")
                sReplaced.contains("eight") -> sReplaced.replace("eight", "8")
                sReplaced.contains("nine") -> sReplaced.replace("nine", "9")
                sReplaced.contains("zero") -> sReplaced.replace("zero", "0")
                else -> sReplaced
            }
        }
        return sReplaced.toInt()
    }
}