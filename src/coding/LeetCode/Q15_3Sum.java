package coding.LeetCode;

import java.util.*;

public class Q15_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ret = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int s = i+1;
            int e = nums.length-1;
            while(s < e){
                int sum = nums[i] + nums[s] + nums[e];
                if(sum == 0){
                    ret.add(Arrays.asList(nums[i], nums[s],nums[e]));
                    s++;
                    e--;
                }else if(sum < 0){
                    s++;
                }else{
                    e--;
                }
            }
        }
        res.addAll(ret);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{0,1,1}));
        System.out.println(threeSum(new int[]{0,0,0}));
    }
}
