package net.soy.algorithm.level1.devMatching2021.theTopAndBottomOfTheLottery

/**
 * Algorithm
 * 코딩테스트 연습 > 2021 Dev-Matching: 웹 백엔드 개발 > 로또의 최고 순위와 최저 순위
 * @author LEESOYOUNG
 * @since 2021-09-28
 */
class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {

        var unknownNumbers = 0  //모르는 번호 (0)
        val myNumbers = arrayListOf<Int>()   // 모르는 번호 제외 나의 번호

        lottos.sorted().forEach {
            if(it == 0){
                unknownNumbers += 1
            } else {
                myNumbers.add(it)
            }
        }

        //최소 당첨된 번호 개수
        val minScore = myNumbers.count {
            it in win_nums.sorted()
        }

        //최대 당첨된 번호 개수
        val maxScore = minScore + unknownNumbers

        return intArrayOf(scoreResult(maxScore), scoreResult(minScore))
    }

    //당첨 개수 -> 순위
    private fun scoreResult(num: Int) = when (num) {
        6 -> 1
        5 -> 2
        4 -> 3
        3 -> 4
        2 -> 5
        else -> 6
    }

}