package coding.프로그래머스.고득점kit.동적프로그래밍;

public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        //top-down
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if(j == 0){
                    dp[i][j] = dp[i-1][j]+triangle[i][j];
                }else if(j == triangle[i].length-1){
                    dp[i][j] = dp[i-1][j-1]+triangle[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1]+triangle[i][j], dp[i-1][j]+triangle[i][j]);
                }
            }
        }
        for (int i = 0; i < triangle[triangle.length-1].length; i++) {
            answer = Math.max(dp[triangle.length-1][i], answer);
        }
        return answer;
    }
}
