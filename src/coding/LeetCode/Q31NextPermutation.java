package coding.LeetCode;

import java.util.Collections;

public class Q31NextPermutation {
    /*
    Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
    Find the largest index l greater than k such that a[k] < a[l].
    Swap the value of a[k] with that of a[l].
    Reverse the sequence from a[k + 1] up to and including the final element a[n].
     */
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] < nums[i+1]){
                pivot = i;
            }
        }
        int l = -1;
        if(pivot != -1){
            for (int i = 0; i < nums.length; i++) {
                if(nums[pivot] < nums[i]){
                    l = Math.max(l, i);
                }
            }
        }else{
            reverse(nums, 0, nums.length-1);

        }

        int temp = nums[pivot];
        nums[pivot] = nums[l];
        nums[l] = temp;
        reverse(nums, pivot+1, nums.length-1);
    }
    public void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

}
