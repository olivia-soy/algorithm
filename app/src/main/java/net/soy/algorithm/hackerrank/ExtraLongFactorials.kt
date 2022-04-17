package net.soy.algorithm.hackerrank

import java.math.BigInteger

/**
 * Algorithm
 * Extra Long Factorials
 * @author leesoyoung
 * @since 2022/04/17
 */

class ExtraLongFactorials {
    fun solution(n: Int): BigInteger {
        return (1..n).fold(BigInteger.ONE) { total, next -> total.multiply(next.toBigInteger()) }
    }
}