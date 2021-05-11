package net.soy.algorithm

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun solution() {
        val a: IntArray = intArrayOf(-1,0,1)
        val b: IntArray = intArrayOf(1,0,-1)
        var answer = 0
        a.forEachIndexed { aIndex, _ ->
            answer += a[aIndex] * b[aIndex]
        }
        println(answer)
    }
}
