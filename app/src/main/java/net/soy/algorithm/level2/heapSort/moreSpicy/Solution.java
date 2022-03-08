package net.soy.algorithm.level2.heapSort.moreSpicy;

import java.util.PriorityQueue;

/**
 * Algorithm
 * 코팅테스트 연습 > 힙(Heap) > 더 맵게
 *
 * 우선순위 큐 문제 : Priority Queue
 *
 * @author LEESOYOUNG
 * @since 2021-09-30
 */
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();

        for (int j : scoville) {
            priorityQueueLowest.add(j);
        }

        while (priorityQueueLowest.peek() < K) {
            try {
                int firstLow = priorityQueueLowest.poll();
                int secondLow = priorityQueueLowest.poll();
                priorityQueueLowest.add(mixScoville(firstLow, secondLow));
                answer += 1;
            } catch (NullPointerException e) {
                return -1;
            }
        }

        return answer;
    }

    private int mixScoville(int firstLow, int secondLow) {
        return firstLow + (secondLow * 2);
    }
}