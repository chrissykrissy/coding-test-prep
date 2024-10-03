package coding.프로그래머스.고득점kit.깊이너비우선탐색;

import java.util.*;
public class 아이템줍기 {

    static int[][] map;
    static int[][] dir = {{0, 1}, {0,-1}, {1, 0}, {-1, 0}};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        for(int[] r : rectangle) draw(2 * r[0], 2 * r[1], 2 * r[2], 2 * r[3]);
        return bfs(2*characterX, 2*characterY, 2*itemX, 2*itemY);
    }

    private int bfs(int x, int y, int findX, int findY){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        boolean[][] visited = new boolean[101][101];
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] prev = q.poll();
            int prevX = prev[0];
            int prevY = prev[1];
            int count = prev[2];
            
            if(prevX == findX && prevY == findY){
                return count/2;
            }
            for(int[] d : dir){
                int nextX = prevX + d[0];
                int nextY = prevY + d[1];

                if(nextX < 0 || nextY < 0 || nextY >= map[0].length || nextX >= map.length || visited[nextX][nextY] || map[nextX][nextY] != 1){
                    continue;
                }

                visited[nextX][nextY]=true;
                q.add(new int[]{nextX, nextY, count+1});
            }
        }
        return 0;
    }
    
    private void draw(int x1, int y1, int x2, int y2){
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if(map[i][j] == 2) continue;
                map[i][j] = 2;
                if(i == x1 || i == x2 || j == y1 || j == y2){
                    map[i][j] = 1;
                }
            }
        }
    }
    
}
