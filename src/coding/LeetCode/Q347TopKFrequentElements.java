package coding.LeetCode;

import java.util.*;

public class Q347TopKFrequentElements {
    public static int[] topKFrequent_PQ(int[] nums, int k) {
        int[] ans = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for(Integer i : map.keySet()){
            int[] add = new int[]{i, map.get(i)};
            pq.add(add);
        }
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

    public static int[] topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(int i : map.keySet()){
            int freq = map.get(i);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(i);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = bucket.length-1; i >= 0 ; i--) {
            if(bucket[i] != null){
                for(int v : bucket[i]){
                    res[index++] = v;
                    if(index == k) return res;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
    }
}
