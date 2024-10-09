package coding.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q56MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        int[] currI = intervals[0];
        res.add(currI);
        for(int i = 0; i < intervals.length; i++){
            int[] interval = intervals[i];
            if(interval[0] <= currI[1]){
                currI[1] = Math.max(currI[1], interval[1]);
            }else {
                currI = interval;
                res.add(currI);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static int[][] merge2(int[][] intervals){
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length; i++) {
            if(list.isEmpty() || list.get(list.size()-1)[1] < intervals[i][0]){
                list.add(intervals[i]);
            }else{
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], intervals[i][1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {4, 5}})));
    }
}
