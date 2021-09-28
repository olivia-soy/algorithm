package net.soy.algorithm.level2.sort.hIndex

/**
 * 코딩테스트 연습 > 정렬 > H-Index
 *
 * @author LEESOYOUNG
 * @since 2021-08-31
 */
class Solution {
    fun solution(citations: IntArray): Int {
        val sortedCitations = citations.sortedDescending() // 내림차순으로 정렬

        sortedCitations.forEachIndexed { index, i ->
            if(index >= i){
                return index
            }
        }

        return sortedCitations.size
    }
}