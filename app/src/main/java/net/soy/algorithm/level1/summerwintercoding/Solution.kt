package net.soy.algorithm.level1.summerwintercoding

/**
 * Class: Solution
 * Created by leesoyoung on 2021/06/01.
 *
 * Description: 프로그래머스 코딩테스트 연습 Summer/Winter Coding(~2018) 소수 만들기
 *
 */
class Solution {
    fun solution(nums: IntArray): Int {
        var answer = 0
        //key point 1 : 삼중 for 문으로 세 수의 합 구하기
        for (i in 0 until nums.size - 2) {
            for (j in i until nums.size - 1) {
                for (k in j until nums.size) {
                    if(isPrime(nums[i] + nums[j] + nums[k])){
                        answer += 1
                    }
                }
            }
        }
        return answer
    }

    /**
     * 소수인지 판별하는 함수
     * 자기 자신과 1 이외의 수로 나눠지지 않는 수
     */
    private fun isPrime(num: Int): Boolean {
        for (i in 2 until num) {
            if (num % i == 0) {
                return false
            }
        }
        return true
    }
}