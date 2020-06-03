package net.soy.algorithm.level2.hash.camouflage

/**
 * Class: Solution
 * Created by leesoyoung on 2020/06/02.
 *
 * Description: 프로그래머스 코딩테스트 연습 level2 해시 "위장" 문제
 *
 * 확률과 통계 공식으로
 * 종류별로 곱해야 하는데
 * 여기서 안입을 경우를 빼야하므로 종류별로 각각 1을 더하여 곱해주고
 * (종류1 + 1) * (종류2 + 1)
 * 조건에 최소 한 개의 의상은 입는다 나와있으므로 아무것도 안입을 경우는 빼주어야 한다
 *
 * 예를들어
 * {{베레모, 얼굴}, {버킷햇, 얼굴}, {청바지, 하의}, {슬랙스, 하의}, {반팔티, 상의 }}
 *
 * 이렇게 데이터가 들어올경우
 * 종류가 얼굴 : 2 , 하의 : 2, 상의 : 1
 * 이므로 식은
 * (2 + 1) * (2 + 1) * (1 + 1) - 1 이 된다.
 */
class Solution {
    fun solution(clothes: Array<Array<String>>): Int {

        //{"이름","종류"} 형식으로 리스트가 전달되기 때문에 종류별 갯수를 파악하기 위해 component2로 groupBy를 실행한다
        val clothesKinds = clothes.groupBy { it.component2() }

        /**
         * 종류별 리스트의 원소 + 1 을 한 뒤
         * 모든 원소를 곱하고(reduce 함수 사용) -1 을 해준다
         */
        return clothesKinds.keys.map {
            clothesKinds[it]!!.size.plus(1)
        }.reduce { t1, t2 -> t1 * t2}.minus(1)

    }
}