package net.soy.algorithm.codingTest.test2

/**
 * Algorithm
 * mobility
 * @author leesoyoung
 * @since 2022/01/21
 */

interface Repository<T> {
    fun get(): Iterable<T>
}