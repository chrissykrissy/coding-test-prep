package coding.LeetCode;

import java.util.PriorityQueue;

public class Q215KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums){
            pq.add(n);
            while(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
