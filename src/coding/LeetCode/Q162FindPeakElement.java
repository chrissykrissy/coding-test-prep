package coding.LeetCode;

public class Q162FindPeakElement {
    public static int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;

        if(nums.length >= 2){
            if(nums[0] > nums[1]){
                return 0;
            }
            if(nums[nums.length-1] > nums[nums.length-2]){
                return nums.length-1;
            }
        }

        int left = 1; int right = nums.length-2;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else{
                if(nums[mid] < nums[mid-1]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
