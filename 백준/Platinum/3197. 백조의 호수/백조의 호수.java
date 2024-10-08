import java.io.*;
import java.util.*;

public class Main {

    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static List<int[]> swanCoords;
    static boolean[][] waterVisited;

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

        Queue<int[]> waterQueue = new LinkedList<>();
        Queue<int[]> swanQueue = new LinkedList<>();
        boolean[][] swanVisited = new boolean[R][C];
        waterVisited = new boolean[R][C];
        int[] swan1 = swanCoords.get(0);
        int[] swan2 = swanCoords.get(1);

        // 모든 물 좌표를 waterQueue에 넣고 백조의 시작 위치를 swanQueue에 넣음
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (lake[i][j].equals(".")) {
                    waterQueue.add(new int[]{i, j});
                    waterVisited[i][j] = true;
                }
                if (lake[i][j].equals("L")) {
                    waterQueue.add(new int[]{i, j});
                    waterVisited[i][j] = true;
                    if (swanQueue.isEmpty()) {
                        swanQueue.add(new int[]{i, j});
                        swanVisited[i][j] = true;
                    }
                }
            }
        }

        // 하루씩 진행하면서 백조가 만날 수 있는지 확인
        int days = 0;
        while (true) {
            if (canSwansMeet(swanQueue, swanVisited, swan2, lake)) {
                break;
            }
            // 얼음을 녹임
            waterQueue = meltWater(waterQueue, lake);
            days++;
        }
        bw.write(String.valueOf(days-1));
        bw.flush();
    }

    // 백조가 물을 통해 만날 수 있는지 확인하는 BFS
    public static boolean canSwansMeet(Queue<int[]> swanQueue, boolean[][] swanVisited, int[] swan2, String[][] lake) {
        Queue<int[]> nextQueue = new LinkedList<>();
        while (!swanQueue.isEmpty()) {
            int[] pos = swanQueue.poll();
            int x = pos[0];
            int y = pos[1];

            if (x == swan2[0] && y == swan2[1]) {
                return true;  // 두 백조가 만남
            }

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || ny < 0 || nx >= lake.length || ny >= lake[0].length || swanVisited[nx][ny]) {
                    continue;
                }
                swanVisited[nx][ny] = true;
                if (lake[nx][ny].equals(".")) {
                    swanQueue.add(new int[]{nx, ny});  // 물이면 바로 이동
                } else {
                    nextQueue.add(new int[]{nx, ny});  // 얼음이면 나중에 녹은 후 이동
                }
            }
        }
        swanQueue.addAll(nextQueue);
        return false;
    }

    // 하루 동안의 물이 녹는 과정 처리
    public static Queue<int[]> meltWater(Queue<int[]> waterQueue, String[][] lake) {
        Queue<int[]> newWaterQueue = new LinkedList<>();
        while (!waterQueue.isEmpty()) {
            int[] pos = waterQueue.poll();
            int x = pos[0];
            int y = pos[1];

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || ny < 0 || nx >= lake.length || ny >= lake[0].length || waterVisited[nx][ny]) {
                    continue;
                }
                if (lake[nx][ny].equals("X")) {
                    lake[nx][ny] = ".";
                    newWaterQueue.add(new int[]{nx, ny});
                }
                waterVisited[nx][ny] = true;
            }
        }
        return newWaterQueue;
    }
}
