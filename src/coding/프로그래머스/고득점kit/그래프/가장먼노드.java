package coding.프로그래머스.고득점kit.그래프;

import java.lang.reflect.Array;
import java.util.*;

public class 가장먼노드 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] dist = new int[n+1];
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++) {
            //양방향 그래프이기 때문에 양쪽으로 더해준다
            adj[edge[i][0]].add(edge[i][1]);
            adj[edge[i][1]].add(edge[i][0]);
        }

        boolean[] visited = new boolean[n + 1];

        visited[1] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int curr = q.poll();
            ArrayList<Integer> node = adj[curr];
            for (int i = 0; i < node.size(); i++) {
                if(!visited[node.get(i)]){
                    q.add(node.get(i));
                    visited[node.get(i)] = true;
                    dist[node.get(i)] = dist[curr] + 1;
                }
            }
        }

        Arrays.sort(dist);
        int max = dist[n];
        for (int i = n; dist[i] == max; i--) {
            answer++;
        }

        return answer;
    }

}
