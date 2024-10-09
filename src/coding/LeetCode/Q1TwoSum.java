package coding.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Q1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                ret[0] = i;
                ret[1] = map.get(target-nums[i]);
                return ret;
            }
            map.put(nums[i], i);
        }
        return ret;
    }
}
