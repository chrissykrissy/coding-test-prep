package coding.LeetCode;

public class Q1004MaxConsecuttiveOnes3 {
    /*
    approach:
    - basically trying to find the longest consecutive 1s subarray with at most k 0s
    - can use sliding window with left and right pointer
    - if we encounter a 0, increment a zero counter
    - if the number of zeroes > k:
        - move the left boundary of our window to the right
        - decrement the zero counter if we encounter one
        - only move this left boundary up if the zero counter goes over k
        - somewhat of a greedy approach
    - right - left will be our longest subarray
    */
    public static int longestOnes(int[] nums, int k) {
        // longest subarray of 1s with at most k 0s
        int begin = 0, end = 0;
        int zeroes = 0;

        while (end < nums.length) {
            if (nums[end] == 0) {
                zeroes++; // encountered a 0
            }

            end++; // move right side of window to the right

            if (zeroes > k) {
                // move left side of window to the right
                if (nums[begin] == 0) {
                    zeroes--;
                }

                begin++;
            }
        }

        return end - begin;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
