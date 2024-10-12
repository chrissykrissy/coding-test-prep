package coding.LeetCode;

public class Q827MakingALargeIsland_NotEfficient {
    static int max = 0;
    static int island = 0;

    public static int largestIsland(int[][] grid) {
        //for every 0 in the grid try to convert it to 1 and get the area
        boolean[][] visited;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    visited = new boolean[grid.length][grid[0].length];
                    dfs(grid, visited, i, j);
                    grid[i][j] = 0;
                    island = 0;
                } else {
                    count++;
                }
            }
        }
        return Math.max(count, max);
    }

    private static void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        island++;
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j - 1);
        dfs(grid, visited, i, j + 1);
    }

    public static void main(String[] args) {
        System.out.println(largestIsland(new int[][]{{1,0},{0,1}}));
        System.out.println(largestIsland(new int[][]{{1,1},{0,1}}));
        System.out.println(largestIsland(new int[][]{{1,1},{1,1}}));
        System.out.println(largestIsland(new int[][]{{0,0},{0,0}}));
    }

}
