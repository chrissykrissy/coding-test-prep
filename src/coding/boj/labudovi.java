package coding.boj;

import java.io.*;
import java.util.*;

public class labudovi {
    static int[][] dir = new int[][]{{1, 0}, {-1,0}, {0, 1}, {0,-1}};
    static List<int[]> swanCoords;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String[][] lake = new String[R][C];
        for (int i = 0; i < lake.length; i++) {
            st = new StringTokenizer(br.readLine());
            lake[i] = st.nextToken().split("");
        }

        swanCoords = new ArrayList<>();
        for (int i = 0; i < lake.length; i++) {
            for (int j = 0; j < lake[i].length; j++) {
                if(lake[i][j].equals("L")){
                    swanCoords.add(new int[]{i, j});
                }
            }
        }
        int days = 0;
        boolean canVisit = bfs(lake);
        while(!canVisit){
            String[][] tmr = melt(lake);
            days++;
            canVisit = bfs(tmr);
            lake = tmr;
        }
        
        bw.write(String.valueOf(days));
        bw.flush();
    }

    public static String[][] melt(String[][] curr){
        String[][] newLake = new String[curr.length][curr[0].length];
        for (int i = 0; i < curr.length; i++) {
            for (int j = 0; j < curr[i].length; j++) {
                if(curr[i][j].equals("X")){
                    if(check(curr, i, j)){
                        newLake[i][j] = ".";
                    }else{
                        newLake[i][j] = curr[i][j];
                    }
                }else{
                    newLake[i][j] = curr[i][j];
                }
            }
        }
        return newLake;
    }

    private static boolean check(String[][] curr, int i, int j) {
        for (int k = 0; k < dir.length; k++) {
            int nextX = i + dir[k][0];
            int nextY = j + dir[k][1];

            // 경계 조건 확인
            if (nextX < 0 || nextX >= curr.length || nextY < 0 || nextY >= curr[i].length) {
                continue;
            }

            // 얼음이 아닌 인접한 영역이 있으면 true 반환
            if (curr[nextX][nextY].equals(".")) {
                return true;
            }
        }
        return false;
    }

    private static boolean bfs(String[][] curr){
        int[] start = swanCoords.get(0);
        int[] end = swanCoords.get(1);
        boolean[][] visited = new boolean[curr.length][curr[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int i = pos[0];
            int j = pos[1];
            if (i == end[0] && j == end[1]) return true;
            for (int[] d : dir) {
                int nextX = i + d[0];
                int nextY = j + d[1];

                if (nextX < 0 || nextY < 0 || nextY >= curr[0].length || nextX >= curr.length || visited[nextX][nextY] || curr[nextX][nextY].equals("X")) {
                    continue;
                }
                visited[nextX][nextY] = true;
                q.add(new int[]{nextX, nextY});
            }
        }
        return false;
    }
}
