package coding.LeetCode;

import java.util.Arrays;

public class Q34FindFirstnLastPositionOfElementInSortedArray {
    /*
    approach:
    - we can run two binary searches, one for the first and one for the second
    - first position:
        - if arr[mid] >= target:
            right = mid - 1
    - last position:
        - if arr[mid] > target:
            right = mid - 1
    - for both: if arr[mid] = target, keep searching
    */
    public static int[] searchRange(int[] nums, int target) {
        int firstIdx = findFirst(nums, target);
        int secondIdx = findLast(nums, target);
        return new int[]{firstIdx, secondIdx};
    }

    public static int findFirst(int[] nums, int target) {
        int idx = -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }

            if (nums[mid] == target) {
                idx = mid;
            }
        }

        return idx;
    }

    public static int findLast(int[] nums, int target) {
        int idx = -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }

            if (nums[mid] == target) {
                idx = mid;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 0)));
    }
}
