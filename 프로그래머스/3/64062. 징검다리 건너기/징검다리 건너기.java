import java.util.*;
class Solution {
        class MaxQueue{
        Queue<Integer> queue;
        Deque<Integer> maxDeque;

        public MaxQueue(){
            this.queue = new LinkedList<>();
            this.maxDeque = new LinkedList<>();
        }

        public void enq(int val){
            queue.add(val);
            while(!maxDeque.isEmpty()){
                if(maxDeque.getLast() >= val){
                    break;
                }
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
    public int solution(int[] stones, int k) {
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
}