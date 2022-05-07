package net.soy.algorithm.hackerrank

/**
 * # Algorithm
 * # Plus Minus
 * @author LEESOYOUNG
 * @since 2022-04-29
 */
class PlusMinus {
    fun solution(arr: Array<Int>): Unit {
        val d = arr.size.toDouble()
        var zeroAnswer = 0
        var positiveAnswer = 0
        var negativeAnswer = 0
        arr.forEach {
            when {
                it > 0 -> positiveAnswer++
                it < 0 -> negativeAnswer++
                it == 0 -> zeroAnswer++
            }
        }
        //소수점 여섯 자리 출력
        println(String.format("%.6f", positiveAnswer.div(d)))
        println(String.format("%.6f", negativeAnswer.div(d)))
        println(String.format("%.6f", zeroAnswer.div(d)))
    }
}