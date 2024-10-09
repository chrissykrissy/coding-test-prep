package coding.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Q1091ShortestPathInBinaryMatrix {
    static int[][] dir = {{-1,-1}, {-1,0}, {-1,1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public static int shortestPathBinaryMatrix2(int[][] grid) {
        int[][] visited = grid;
        if(grid[0][0] == 1) return -1;
        return bfs2(grid, visited);
    }

    private static int bfs2(int[][] grid, int[][] visited){
        Queue<int[]> path = new LinkedList<>();
        path.add(new int[]{0,0,1});
        while(!path.isEmpty()){
            int[] curr = path.poll();
            int currDist = curr[2];
            visited[curr[0]][curr[1]] = 1;
            if(curr[0] == grid.length-1 && curr[1] == grid.length-1){
                return currDist;
            }
            for(int[] d : dir){
                int newX = curr[0]+d[0];
                int newY = curr[1]+d[1];
                if(newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && grid[newX][newY] != 1 && visited[newX][newY] != 1){
                    path.add(new int[]{newX, newY, currDist+1});
                }
            }
        }
        return -1;
    }

    public static int shortestPathBinaryMatrix(int[][] grid){
        int N = grid.length;
        if(grid[0][0] != 0 || grid[N-1][N-1] != 0) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            dist++; //레벨 계산
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];
                if(x == N-1 && y == N-1) return dist;
                for (int[] d : dir){
                    int nx = x + d[0], ny = y + d[1];
                    if(nx >= 0 && ny >= 0 && nx < N && ny < N && grid[nx][ny] != 1){
                        grid[nx][ny] = 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
            return -1;
    }

    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
        System.out.println(shortestPathBinaryMatrix(new int[][]{{1,0,0},{1,1,0}, {1,1,0}}));
    }
}
