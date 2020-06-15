package net.soy.algorithm.level2.hash.phone_book;

import java.util.Arrays;

/**
 * Class: Solution
 * Created by leesoyoung on 2020/06/15.
 *
 * Description: 프로그래머스 코딩테스트 연습 level2 해시 "전화번호 목록" 문제
 */
public class Solution {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        //배열 정렬
        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length-1; i++){
            if (phone_book[i+1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}