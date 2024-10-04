import java.util.*;
class Solution {
    static int toLever = 0;
    static int[] leverLoc = {};
    static int toEnd = 0;
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int solution(String[] maps) {
        int i = maps.length;
        int j = maps[0].length();

        char[][] grid = new char[i][j];
        for (int k = 0; k < i; k++) {
            grid[k] = maps[k].toCharArray();
        }

        visited = new boolean[i][j];

        int startI = 0, startJ = 0;
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                if(grid[k][l] == 'S'){
                    startI = k;
                    startJ = l;
                    break;
                }
            }
        }

        toLever = bfs(grid, startI, startJ, false);  // 출발점에서 레버까지의 거리 계산
        if(toLever != -1){
            visited = new boolean[i][j];
            toEnd = bfs(grid, leverLoc[0], leverLoc[1], true);  // 레버에서 출구까지의 거리 계산
        }

        if(toLever != -1 && toEnd != -1){
            return toLever + toEnd;
        } else {
            return -1;  // 도달할 수 없는 경우
        }
    }

    public static int bfs(char[][] grid, int si, int sj, boolean lever) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{si, sj, 0});  // {i, j, 현재 거리}
        visited[si][sj] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int distance = curr[2];

            if (grid[i][j] == 'L' && !lever) {
                leverLoc = new int[]{i, j};
                return distance;
            }
            if (grid[i][j] == 'E' && lever) {
                return distance;
            }

            for (int[] d : dir) {
                int newI = i + d[0];
                int newJ = j + d[1];

                if (newI >= 0 && newJ >= 0 && newI < grid.length && newJ < grid[0].length && !visited[newI][newJ] && grid[newI][newJ] != 'X') {
                    q.offer(new int[]{newI, newJ, distance + 1});
                    visited[newI][newJ] = true;  // 큐에 추가할 때 방문 체크
                }
            }
        }

        return -1;  // 도달할 수 없을 때
    }
}