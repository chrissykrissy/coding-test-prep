package coding.LeetCode;

import java.util.PriorityQueue;

public class Q973KClosestPointToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> distance(b[0], b[1]).compareTo(distance(a[0],a[1])));
        for(int[] p : points){
            pq.offer(p);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.toArray(new int[pq.size()][2]);
    }
    public Double distance(int x, int y){
        return Math.sqrt((x*x)+(y*y));
    }
}
