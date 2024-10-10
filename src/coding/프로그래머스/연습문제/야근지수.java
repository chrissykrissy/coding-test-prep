package coding.프로그래머스.연습문제;

import java.util.PriorityQueue;

public class 야근지수 {
    public long solution(int n, int[] works) {
        //피로도 = 야근 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값
        //n = 퇴근까지 남은 시간
        //최소화하려면 제곱하는 숫자가 적어야함
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        while(n > 0 && !pq.isEmpty()){
            int max = pq.poll();
            max--;
            if(max > 0){
                pq.add(max);
            }
            n--;
        }

        long answer = 0;
        while(!pq.isEmpty()){
            int top = pq.poll();
            answer += top*top;
        }
        return answer;
    }
}
