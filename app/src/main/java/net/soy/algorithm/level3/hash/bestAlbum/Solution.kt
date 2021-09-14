package net.soy.algorithm.level3.hash.bestAlbum

/**
 * 코딩테스트 연습 > 해시 > 베스트 앨범
 *
 * @author LEESOYOUNG
 * @since 2021-09-07
 */
class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        return genres.indices.groupBy { unique ->
            genres[unique]
        }.toList()   //map to list
            .sortedByDescending { pair ->   //고유번호(pair.seconds) 를 통해 plays 에서 판매량 합의 내림차순으로 정렬  "속한 노래가 많이 재생된 장르를 먼저 수록"
                pair.second.sumBy { unique ->
                    plays[unique]
                }
            }.map { pair ->
                pair.second.sortedByDescending { //"장르 내에서 많이 재생된 노래를 먼저 수록"
                    plays[it]
                }.take(2)   //take(2) -> "두 개씩 모아 베스트 앨범을 출시"
            }.flatten().toIntArray()  //flatten() -> array 를 하나로 묶음
    }
}