package net.soy.algorithm.level1.hash.uncompletedPlayer;

import java.util.HashMap;

/**
 * Class: Solution
 * Created by leesoyoung on 2020/06/09.
 *
 * Description: 프로그래머스 코딩테스트 연습 level1 해시 "완주하지 못한 선수" 문제
 */
public class Solution {
    public String solution(String[] participant, String[] completion) {
        //동명 이인 선수를 골라내기 위해 hashMap 으로 저장
        HashMap<String, Integer> hashMap = new HashMap<>();

        //참가자의 이름이 있는경우 value 값을 +1해준다
        for(String part: participant){
            if(hashMap.containsKey(part)){
                hashMap.put(part, hashMap.get(part) + 1);
            } else {
                hashMap.put(part, 1);
            }
        }

        //완주자의 이름이 있는경우 value 값을 -1해준다
        for(String comp: completion){
            if(hashMap.containsKey(comp)){
                hashMap.put(comp, hashMap.get(comp) - 1);
            }
        }

        //hashMap value 값 중 0이 아닌경우 완주를 못한것이므로 해당 값 return
        for(String part: participant){
            if(hashMap.get(part) != 0)
                return part;
        }

        return null;
    }
}
