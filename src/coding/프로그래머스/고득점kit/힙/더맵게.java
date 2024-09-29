package coding.프로그래머스.고득점kit.힙;

import java.util.PriorityQueue;
import java.util.Queue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        Queue<Integer> food = new PriorityQueue<>();

        for(int i : scoville){
            food.offer(i);
        }

        int time = 0;
        while(food.peek() < K && food.size() >= 2){
            food.offer(food.poll() + (food.poll()*2));
            time++;
        }

        return food.peek() >= K ? time : -1;
    }
}
