package coding.프로그래머스.고득점kit.그래프;

public class 순위 {
    public int solution(int n, int[][] results) {
        /*
        1. 선수별 경기 결과를 저장, 1>2 => graph[1][2] = 1, 2<1 => graph[2][1] = 0
        2. 주어진 경기 결과 바탕으로 순위 (선수가 N 명일 때, 선수a가 지고, 이긴 경우를 합쳐 N-1인경우
            해당 순위 확정가능 ex) 선수 2, 이김5 + 짐1,3,4 = 4 = 5-1
        3. 선수 A가 B를 이기면 항상 A는 B를 이김, 따라서 B가 C 를 이긴다면 A는 C를 이길 수 있음
         */
        int answer = 0;
        int[][] graph = new int[n+1][n+1];
        for (int i = 0; i < results.length; i++) {
            graph[results[i][0]][results[i][1]] = 1; //이김
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n ; j++) {
                for (int k = 0; k <= n; k++) {
                    if(graph[j][i] == 1 && graph[i][k] == 1){
                        graph[j][k] = 1; //j > i, i > k => j > k
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int game = 0;
            for (int j = 1; j <= n; j++) {
                if(graph[i][j] == 1 || graph[j][i] == 1) game++;
            }
            if(game == n-1) answer++;
        }

        return answer;
    }
}
