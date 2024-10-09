package coding.LeetCode;
import java.util.*;
public class Q56FollowUp {

    public static class IntervalMergerTreeMap {
        private TreeMap<Integer, int[]> mergedIntervals;

        public IntervalMergerTreeMap() {
            this.mergedIntervals = new TreeMap<>();
        }

        public void addInterval(int[] newInterval) {
            // Get overlapping intervals
            Integer floor = mergedIntervals.floorKey(newInterval[0]);
            if (floor != null && mergedIntervals.get(floor)[1] >= newInterval[0]) {
                newInterval[0] = Math.min(newInterval[0], mergedIntervals.get(floor)[0]);
                newInterval[1] = Math.max(newInterval[1], mergedIntervals.get(floor)[1]);
                mergedIntervals.remove(floor);
            }

            Integer higher = mergedIntervals.ceilingKey(newInterval[0]);
            while (higher != null && mergedIntervals.get(higher)[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], mergedIntervals.get(higher)[1]);
                mergedIntervals.remove(higher);
                higher = mergedIntervals.ceilingKey(newInterval[0]);
            }

            // Add the new merged interval
            mergedIntervals.put(newInterval[0], newInterval);
        }

        public List<int[]> getMergedIntervals() {
            return new ArrayList<>(mergedIntervals.values());
        }
    }

    public static void main(String[] args) {
        IntervalMergerTreeMap intervalMergerTreeMap = new IntervalMergerTreeMap();
        intervalMergerTreeMap.addInterval(new int[]{1,3});
        intervalMergerTreeMap.addInterval(new int[]{2,6});
        intervalMergerTreeMap.addInterval(new int[]{8,10});
        intervalMergerTreeMap.addInterval(new int[]{15,18});
        System.out.println(intervalMergerTreeMap.getMergedIntervals());
//        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
//        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {4, 5}})));
    }
}
