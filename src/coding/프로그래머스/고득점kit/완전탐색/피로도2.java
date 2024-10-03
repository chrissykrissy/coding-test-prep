package coding.프로그래머스.고득점kit.완전탐색;

public class 피로도2 {

    private static int answer;
    private static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, dungeons, k);
        return answer;
    }

    private void dfs(int depth, int[][] d, int k){
        for (int i = 0; i < d.length; i++) {
            if(!visited[depth] && k >= d[i][0]){
                visited[i] = true;
                dfs(depth+1, d, k-d[i][1]);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }

}
