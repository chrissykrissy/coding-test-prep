package coding.LeetCode;

import java.util.HashMap;

public class Q560SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sumSoFar = 0;
        int result = 0;
        map.put(0, 1);
        for(int x : nums){
            sumSoFar+=x;
            int prev = sumSoFar - k;
            if(map.containsKey(prev)){
                result += map.get(prev);
            }
            map.put(sumSoFar, map.getOrDefault(sumSoFar, 0)+1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,3,2}, 5));
    }
}
