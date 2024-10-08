package coding.LeetCode;

public class Q238MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){ //idx counts number of zeros!!
                nums[idx] = nums[i];
                idx++;
            }
        }
        while(idx < nums.length){
            nums[idx++] = 0;
        }
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
}
