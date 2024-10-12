package coding.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q827MakingALargeIsland {
    /*
    - find all the distinct regions in the grid and name then with num starting 2 (1, 0 reserved)
    - we apply the flood fill algo
    - while applying the flood fill algo, get the rea of the region and store it
    - once we have marked all the regions, now merge multiple islands if there is just one 0 separating these
    - iterate over all the 0s and check distinct neighbors, if they become one island, flip 0 to 1
    - add the area for all the neighbors
    - if the area is greater than the max area, we update the max
     */
    public static int largestIsland(int[][] grid) {
        Map<Integer, Integer> regionArea = new HashMap<>();
        regionArea.put(0,0);

        int n = grid.length;
        int region = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    int area = floodFill(grid, i, j, region);
                    regionArea.put(region, area);
                    region++;
                }
            }
        }
        int max = regionArea.getOrDefault(2, 0);
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if(grid[r][c] == 0){
                    Set<Integer> neighbors = new HashSet<>();
                    neighbors.add(r > 0 ? grid[r - 1][c] : 0);
                    neighbors.add(c > 0 ? grid[r][c - 1] : 0);
                    neighbors.add(r < n-1 ? grid[r + 1][c] : 0);
                    neighbors.add(c < n-1 ? grid[r][c + 1] : 0);
                    int area = 1;
                    for (int neigh : neighbors) {
                        area += regionArea.get(neigh);
                    }
                    if (area > max) {
                        max = area;
                    }
                }
            }
        }
        return max;
    }

    private static int floodFill(int[][] grid, int i, int j, int region) {
        int n = grid.length;
        if(i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1){
            return 0;
        }
        grid[i][j] = region;
        int sum = 1;
        sum += floodFill(grid, i, j + 1, region);
        sum += floodFill(grid, i+1, j, region);
        sum += floodFill(grid, i, j - 1, region);
        sum += floodFill(grid, i-1, j, region);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(largestIsland(new int[][]{{1,0},{0,1}}));
//        System.out.println(largestIsland(new int[][]{{1,1},{0,1}}));
//        System.out.println(largestIsland(new int[][]{{1,1},{1,1}}));
//        System.out.println(largestIsland(new int[][]{{0,0},{0,0}}));
    }
}
