package coding.프로그래머스.고득점kit.완전탐색;

import java.util.*;
public class 전력망을둘로나누기 {
    static int[][] graph;
    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new int[n+1][n+1];

        //양방향 그래프를 세팅해줌
        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0], to = wires[i][1];
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0], to = wires[i][1];
            //하나씩 끊어봄
            graph[from][to] = 0;
            graph[to][from] = 0;

            //끊고서 이어져 있는 갯수를 셈
            answer = Math.min(answer, bfs(n, from));
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        return answer;

    }

    private int bfs(int n, int from) {
        boolean[] visited = new boolean[n+1];
        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        visited[from] = true;
        q.offer(from);

        while(!q.isEmpty()){
            int temp = q.poll();
            //1번 노드부터 탐색
            for (int i = 1; i <= n; i++) {
                if(graph[temp][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                    count++;
                }
            }
        }
        return (int) Math.abs(count - (n - count));
    }

}
