package net.soy.algorithm.level1.weeklycodechallenge.second_week

/**
 */
class Solution {
    fun solution(scores: Array<IntArray>): String {
        val length = scores.size
        val subLength = scores.first().size
        val myScore: Array<Array<Int>> = Array(subLength) { Array(length) { 1 } }



        for (i in 0 until length){
            for(j in 0 until subLength){
                myScore[i][j] = scores[j][i]
            }
        }



        println(myScore)

        return ""
    }


    private fun checkScore(score: Int): String{
       return when(score){
            in 0 until 50  -> "F"
            in 50 until 70  -> "D"
            in 70 until 80  -> "C"
            in 80 until 90  -> "B"
            else -> "A"
        }
    }
}