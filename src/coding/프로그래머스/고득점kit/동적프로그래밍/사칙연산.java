package coding.프로그래머스.고득점kit.동적프로그래밍;

import java.util.*;

public class 사칙연산 {
    public int solution2(String arr[]) {
        int answer = -1;
        int numCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if(!arr[i].equals("-") && !arr[i].equals("+")){
                numCount++;
            }
        }

        int[][] maxDP = new int[numCount][numCount];
        int[][] minDP = new int[numCount][numCount];

        for (int i = 0; i < numCount; i++) {
            Arrays.fill(maxDP[i], Integer.MIN_VALUE);
            Arrays.fill(minDP[i], Integer.MAX_VALUE);
        }

        for (int step = 0; step < numCount; step++) {
            for (int i = 0; i < numCount-step; i++) {
                int j = i + step;

                if (step == 0){
                    maxDP[i][i] = Integer.parseInt(arr[i]);
                }else{
                    for (int k = i; k < j; k++) {
                        if(arr[k].equals("+")){
                            maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] + maxDP[k+1][j]);
                            minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] + minDP[k+1][j]);
                        }else{
                            maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] - maxDP[k+1][j]);
                            minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] - minDP[k+1][j]);
                        }
                    }
                }
            }
        }
        return maxDP[0][numCount-1];
    }

    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;
        int op = arr.length - n;
        int[] numbers = new int[n + 1];
        String[] operators = new String[op + 1];

        int idx1 = 1;
        int idx2 = 1;
        for(int i = 0; i < arr.length; i++){
            if(i % 2 == 0) {
                numbers[idx1++] = Integer.parseInt(arr[i]);
            } else {
                operators[idx2++] = arr[i];
            }
        }
        // 초기화
        int[][][] dp = new int[n + 1][n + 1][2];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j][0] = Integer.MAX_VALUE;
                dp[i][j][1] = Integer.MIN_VALUE;
            }
        }

        // 첫 자리는 자기 자신으로 초기화
        for(int i = 1; i <= n; i++) {
            dp[i][i][0] = numbers[i];
            dp[i][i][1] = numbers[i];
        }

        for(int len = 2; len <= n; len++) { //길이
            for(int i = 1; i <= n - len + 1; i++) { //시작
                int j = i + len - 1; //종료
                for(int k = i; k < j; k++) { //중간포인터
                    //각 구간의 최소, 최대값에 대한 경우의 수 4가지 고려
                    int v1 = calculate(dp[i][k][0], operators[k], dp[k + 1][j][0]);
                    int v2 = calculate(dp[i][k][0], operators[k], dp[k + 1][j][1]);
                    int v3 = calculate(dp[i][k][1], operators[k], dp[k + 1][j][0]);
                    int v4 = calculate(dp[i][k][1], operators[k], dp[k + 1][j][1]);

                    int min = Math.min(v1, Math.min(v2, Math.min(v3, v4)));
                    int max = Math.max(v1, Math.max(v2, Math.max(v3, v4)));

                    dp[i][j][0] = Math.min(dp[i][j][0], min);
                    dp[i][j][1] = Math.max(dp[i][j][1], max);
                }
            }
        }

        return dp[1][n][1];
    }

    private int calculate(int a, String op, int b) {
        if("+".equals(op)) return a + b;

        return a - b;
    }

    public static void main(String[] args) {

    }
}
