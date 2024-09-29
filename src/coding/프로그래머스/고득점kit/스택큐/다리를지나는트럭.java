package coding.프로그래머스.고득점kit.스택큐;

import java.util.*;

public class 다리를지나는트럭 {
    public static int mySolution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i : truck_weights){
            q.offer(i);
        }

        int curr = 0;
        int currWeight = truck_weights[curr];
        int currTime = 0;
        while (!q.isEmpty() && curr <= truck_weights.length-2){
            for (int i = curr+1; i < curr+2; i++) {
                if (currWeight + truck_weights[i] <= bridge_length) {
                    q.poll();
                    currTime += 1;
                    currWeight = currWeight + truck_weights[i];
                } else {
                    currTime += bridge_length;
                    currWeight = truck_weights[i];
                }
            }
            curr++;

        }
        return currTime+1;

    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int sum = 0; //다리 건너는 트럭 무게 합

        for(int t : truck_weights){
            while(true){
                if(q.isEmpty()){
                    q.offer(t);
                    sum += t;
                    answer++;
                    break;
                }else if (q.size() == bridge_length){
                    sum -= q.poll();
                } else{
                    if(sum + t > weight){
                        q.offer(0);
                        answer++;
                    }else{
                        q.offer(t);
                        sum += t;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }



        public static void main(String[] args) {
        int[] t_weights = {7,4,5,6};
        System.out.println(solution(2, 10, t_weights));
    }


}
