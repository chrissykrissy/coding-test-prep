package coding.LeetCode;

public class Q88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < n){
            if(nums1[i] <= nums2[j]){
                if(nums1[i] == 0){
                    nums1[i] = nums2[j];
                    j++;
                }
                i++;
            }else{
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i++;
            }
        }
    }
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;

        for(int p = m+n-1; p >= 0; p--){
            if(p2 < 0) break;
            if(p1>= 0 && nums1[p1] > nums2[p2]){
                nums1[p] = nums1[p1--];
            }else{
                nums1[p] = nums2[p2--];
            }
        }
    }

    public static void main(String[] args) {
        merge2(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}