package coding.프로그래머스.고득점kit.동적프로그래밍;

public class 등굣길 {
    public static int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1; //집의 위치

        //puddle 의 위치를 -1 로 설정해줌
        for(int[] p : puddles){
            dp[p[1]][p[0]] = -1;
        }

        //집 -> 학교 : 오른쪽과 아래쪽으로만 움직일 수 있음 (top-down)
        //학교 -> 집 : 왼쪽과 윗쪽으로만 움직일 수 있음 (bottom-up)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(dp[i][j] != -1){
                    dp[i][j] += Math.max(dp[i-1][j], 0) + Math.max(dp[i][j-1], 0);
                    dp[i][j] %= 1_000_000_007;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2,2}}));
    }
}
