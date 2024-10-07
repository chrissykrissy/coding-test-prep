package coding.boj;

import java.io.*;
import java.util.StringTokenizer;

public class 배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int[] w = new int[num+1]; // 물건의 무게
        int[] v = new int[num+1]; // 물건의 가치

        for (int i = 1; i <= num; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[num+1][max+1]; // 무게에 따른 DP 배열 크기 수정

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= max ; j++) {
                if(j >= w[i]){ // i번 물건을 추가할 수 있으면
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]); // i번째 물건의 무게 참조 수정
                } else { // 추가할 수 없다면
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        bw.write(String.valueOf(dp[num][max])); // 최종 값 출력
        bw.flush();
    }
}