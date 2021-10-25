package net.soy.algorithm.level2.stackQueue.stockPrice;

/**
 * Algorithm
 * 코팅테스트 연습 > 스택/큐 > 주식 가격
 *
 * @author LEESOYOUNG
 * @since 2021-09-30
 */
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i< prices.length ; i++) {
            for (int j =i+1; j < prices.length; j++) {
                answer[i]++;
                if(prices[i]>prices[j])break;
            }
        }
        return answer;
    }
}