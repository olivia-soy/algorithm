package net.soy.algorithm.level1.kakaoblindrecruitment

/**
 * Class: Solution
 * Created by leesoyoung on 2021/06/20.
 *
 * Description: 프로그래머스 코딩테스트 연습 2021 KAKAO BLIND RECRUITMENT 신규 아이디 추천
 */
class Solution {
    fun solution(new_id: String): String {
        var answer: String = ""
        step1(new_id).also { answer = it }
        step2(answer).also { answer = it }
        step3(answer).also { answer = it }
        step4(answer).also { answer = it }
        step5(answer).also { answer = it }
        step6(answer).also { answer = it }
        step7(answer).also { answer = it }
        return answer
    }

    /**
     * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
     */
    private fun step1(new_id: String): String {
        return new_id.toLowerCase()
    }

    /**
     * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
     */
    private fun step2(new_id: String): String {
        val sb = StringBuffer(new_id)
        val result = sb.filter {
            it in 'a'..'z' || it in '0'..'9' || it == '-' || it == '_' || it == '.'
        }
        return result.toString()
    }

    /**
     * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
     */
    private fun step3(new_id: String): String {
        var result = new_id
        while (result.contains("..")) {
            result = result.replace("..", ".")
        }
        return result
    }

    /**
     * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
     */
    private fun step4(new_id: String): String {
        var result = new_id
        result = result.removePrefix(".")   //접두사가 해당 문자일 경우 제거
        result = result.removeSuffix(".")   //접미사가 해당 문자일 경우 제거
        return result
    }

    /**
     * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
     */
    private fun step5(new_id: String): String {
        return if (new_id.isBlank()) {
            "a"
        } else {
            new_id
        }
    }

    /**
     * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     * 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
     */
    private fun step6(new_id: String): String {
        var result = new_id
        if (result.toCharArray().size > 15) {
            result = result.removeRange(15, result.toCharArray().size)
        }
        return step4(result)
    }

    /**
     * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
     */
    private fun step7(new_id: String): String {
        val result = StringBuffer(new_id)
        if (result.length < 3) {
            while (result.length < 3) {
                result.append(result.last())
            }
        }
        return result.toString()
    }
}