package coding.프로그래머스.PCCP;

import java.util.*;

public class 충돌위험찾기_practice {
    static Map<String, Set<Integer>> visited = new HashMap<>();
    static int crash = 0;
    static int N;
    static int M;
    static Map<Integer, int[]> location;

    public static int solution(int[][] points, int[][] routes) {
        location = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            location.put(i+1, points[i]);
            N = Math.max(N, points[i][0] + 1);  // N 값을 올바르게 설정
            M = Math.max(M, points[i][1] + 1);  // M 값을 올바르게 설정
        }

        for (int i = 0; i < routes.length; i++) {
            for (int j = 1; j < routes[i].length; j++) {
                int start = routes[i][j-1];
                int end = routes[i][j];
                bfs(start, end);
            }
        }
        return crash;
    }

    private static void bfs(int from, int to) {
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        int[] startPoint = location.get(from);
        int[] endPoint = location.get(to);
        String startLoc = startPoint[0] + "," + startPoint[1];
        String endLoc = endPoint[0] + "," + endPoint[1];

        q.add(new int[]{startPoint[0], startPoint[1], 0}); // 시작점과 시간 추가
        visited.putIfAbsent(startLoc, new HashSet<>());
        visited.get(startLoc).add(0);  // 시작점 방문 처리

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            String currloc = curr[0] + "," + curr[1]; // 현재 위치를 문자열로 변환

            // 목적지에 도착하면 종료
            if (currloc.equals(endLoc)) {
                return;
            }

            // 다음 위치로 이동
            for (int[] d : dir) {
                int nx = curr[0] + d[0];
                int ny = curr[1] + d[1];
                int time = curr[2] + 1;

                // 범위를 벗어나지 않고 방문하지 않았으면 큐에 추가
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    String nextLoc = nx + "," + ny;
                    if (!visited.containsKey(nextLoc) || !visited.get(nextLoc).contains(time)) {
                        // 충돌 처리
                        if (visited.containsKey(nextLoc)) {
                            crash++;  // 동일한 좌표에 이미 다른 경로에서 왔을 경우 충돌 증가
                        }
                        q.add(new int[]{nx, ny, time});  // 큐에 추가
                        visited.putIfAbsent(nextLoc, new HashSet<>());
                        visited.get(nextLoc).add(time);  // 방문 처리
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{3,2},{6,4},{4,7},{1,4}}, new int[][]{{4,2}, {1,3}, {2,4}}));
    }
}