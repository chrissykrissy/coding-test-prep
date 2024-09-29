package coding.프로그래머스.고득점kit.스택큐;

import java.util.*;

public class 프로세스 {
    static class Process {
        int id;
        int priority;

        public Process(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    public static int mySolution(int[] priorities, int location) {
        Queue<Process> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            Process p = new Process(i, priorities[i]);
            q.add(p);
        }

        int times = 0;
        while(times < priorities.length){
            Process tmp = q.peek();
            for (int i = tmp.id+1; i < priorities.length; i++) {
                if(priorities[i] > tmp.priority){
                    q.poll();
                    q.add(tmp);
                    break;
                }
            }
            times++;
        }

        int count = 1;
        while(!q.isEmpty()){
            if(q.poll().id == location){
                return count;
            }
            count++;
        }

        return -1;
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : priorities) {
            pq.add(num);
        }
        while(!pq.isEmpty()){
            for (int i = 0; i < priorities.length; i++) {
                if(priorities[i] == pq.peek()){
                    pq.poll();
                    answer++;
                    if(i == location){
                        return answer;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] p1 = {2,1,3,2};
        int loc1 = 2;
        int[] p2 = {1,1,9,1,1,1};
        int loc2 = 0;
        System.out.println(solution(p1,loc1));
        System.out.println(solution(p2,loc2));
    }

}
