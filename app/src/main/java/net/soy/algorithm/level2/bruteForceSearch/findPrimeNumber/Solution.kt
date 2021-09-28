package net.soy.algorithm.level2.bruteForceSearch.findPrimeNumber

/**
 * Class: Solution
 * Created by leesoyoung on 2020/06/05.
 *
 * Description: 프로그래머스 코딩테스트 연습 level2 완전탐색 "소수 찾기" 문제
 */
class Solution {
    fun solution(numbers: String): Int {

        //중복 제거를 위해 HashSet 사용
        val set: HashSet<Int> = HashSet()

        permutation("", numbers, set)



        val answer: List<Int> = set.filter { isPrime(it) }

        return answer.size
    }


    /**
     * 소수인지 확인하는 메소드
     * 소수 : 자신과 1이외의 어떤수로도 나누어 떨어지지 않는 정수
     */
    fun isPrime(num: Int): Boolean{
        if(num == 1 || num == 0) return false
        for(i in 2 until num){
            if(num % i == 0){
                return false
            }
        }
        return true
    }

    /**
     * 조합
     */
    fun permutation(
        prefix: String,
        numbers: String,
        set: HashSet<Int>
    ) {

        if (prefix != "") set.add(prefix.toInt())

        for (i in numbers.indices) {
            permutation(
                prefix + numbers[i],
                numbers.substring(0, i) + numbers.substring(i + 1),
                set
            )
        }
    }
}