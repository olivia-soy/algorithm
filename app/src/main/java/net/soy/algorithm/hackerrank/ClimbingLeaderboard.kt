package net.soy.algorithm.hackerrank

/**
 * Algorithm
 * Climbing the Leaderboard
 * @author leesoyoung
 * @since 2022/04/17
 */

class ClimbingLeaderboard {
    /**
     * 한 아케이드 게임 플레이어가 리더보드의 맨 위에 올라가 순위를 추적하려고 합니다.
     * 이 게임은 Dense Ranking을 사용하므로 리더보드는 다음과 같이 작동합니다.
     * - 가장 높은 점수를 받은 플레이어는 리더보드에 랭크된 번호입니다.
     * - 점수가 같은 선수는 같은 랭킹 번호를 받고, 다음 선수는 바로 다음 랭킹 번호를 받는다.
     *
     *
     * Terminated due to timeout :(
     */
    private var startIndex = 0
    fun solution(ranked: Array<Int>, player: Array<Int>): Array<Int> {
        val distinctRanked = ranked.distinct()

        return player.reversed().map {
            println(it)
            checkRank(distinctRanked.toTypedArray(), it)
        }.reversed().toTypedArray()
    }

    private fun checkRank(ranked: Array<Int>, score: Int): Int {
        var rank = ranked.size + 1
        for (i in startIndex until ranked.size) {
            if (ranked[i] <= score) {
                rank = i + 1
                break
            } else {
                startIndex++
            }
        }
        return rank
    }
}