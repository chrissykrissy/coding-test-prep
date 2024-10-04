package coding.프로그래머스.연습문제;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 징검다리건너기 {

    static class MaxQueue{
        Queue<Integer> queue;
        Deque<Integer> maxDeque;

        public MaxQueue(){
            this.queue = new LinkedList<>();
            this.maxDeque = new LinkedList<>();
        }

        public void enq(int val){
            queue.add(val);
            //largest should always be the first
            while(!maxDeque.isEmpty()){
                if(maxDeque.getLast() >= val){
                    break;
                }
                //remove if last is less than val
                maxDeque.removeLast();
            }
            maxDeque.addLast(val);
        }

        public int poll(){
            if(!queue.isEmpty()){
                int result = queue.poll();
                if(result == maxDeque.peekFirst()){
                    maxDeque.removeFirst();
                }
                return result;
            }
            return Integer.MIN_VALUE;
        }

        public int max(){
            if(maxDeque.isEmpty()){
                return Integer.MIN_VALUE;
            }
            return maxDeque.getFirst();
        }
    }
    public static int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        MaxQueue mq = new MaxQueue();
        for (int i = 0; i < stones.length; i++) {
            mq.enq(stones[i]);
            if(i >= k-1){
                answer = Math.min(answer, mq.max());
                mq.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }
}
