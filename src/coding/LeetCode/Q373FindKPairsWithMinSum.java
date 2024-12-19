package coding.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q373FindKPairsWithMinSum {
    public static void main(String[] args) {
        int[] nums1 = {1,2,4,5,6};
        int[] nums2 = {3,5,7,9};
        kSmallestPairs(nums1, nums2, 20);
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (nums1[a[0]]+nums2[a[1]]) - (nums1[b[0]]+nums2[b[1]]));
        //[i,j] -> [i+1, j] , [i, j+1];
        List<List<Integer>> ret = new ArrayList<>();
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        int i = 0, j = 0;
        pq.add(new int[]{i, j});
        while (k > 0 && !pq.isEmpty()) {
            int[] popped = pq.poll();
            visited[popped[0]][popped[1]] = true;
            List<Integer> convert = Arrays.asList(nums1[popped[0]], nums2[popped[1]]);
            ret.add(convert);
            k--;
            if (popped[0]+1 < nums1.length && !visited[popped[0]+1][popped[1]]){
                pq.add(new int[]{popped[0]+1, popped[1]});
            }
            if (popped[1]+1 < nums2.length && !visited[popped[0]][popped[1]+1]) {
                pq.add(new int[]{popped[0], popped[1]+1});
            }
        }
        return ret;
    }
}
