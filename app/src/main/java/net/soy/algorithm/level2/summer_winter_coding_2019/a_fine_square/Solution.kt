package net.soy.algorithm.level2.summer_winter_coding_2019.a_fine_square

import android.util.Log

/**
 * Class: Solution
 * Created by leesoyoung on 2020/06/01.
 *
 * Description: 프로그래머스 코딩테스트 연습 level2 Summer/Winter Coding(2019) "멀쩡한 사각형"
 *
 * 1. 사각형의 최소단위를 생각한다 > 가로, 세로를 각각 최대 공약수로 나눈값
 *
 * 2. 예를들어 최소단위가 w : 2, h : 3 이 된다면 점선은 가로 2개 세로 3개의 사각형을 지나가고 그중 가로 세로가 겹치는 부분이 하나가 있으므로 - 1 을 해준다
 *    즉, (2+ 3 - 1)
 *
 * 3. 사각형을 최소단위로 생각하였으므로 그 값에서 다시 최대 공약수를 곱하면 빠지는 사각형의 갯수가 된다
 *
 *
 * 4. 즉 빠지는 사각형의 갯수는 (w/gcd + h/gcd - 1)* gcd = w + h - gcd
 *
 *
 */
class Solution {


    fun solution(w: Int, h: Int): Long {
        val longW = w.toLong()
        val longH = h.toLong()

        return longW*longH - (longW + longH - gcd(maxOf(longW, longH), minOf(longW, longH)))
    }

    /**
     *  최대 공약수 구하는 메소드
     *  큰수를 작은 값으로 나눈 값이 0일 경우 작은값이 최대 공약수
     *  아닐경우 변경하여 과정을 반복하면 된다
     */
    private fun gcd(max: Long, min: Long): Long{
        return if( min == 0L) max else gcd(min, max%min)
    }
}