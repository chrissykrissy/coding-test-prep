package coding.프로그래머스.고득점kit.그리디;

import java.util.Arrays;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] status = new int[n+1];
        Arrays.fill(status, 1);
        for (int k : lost) {
            status[k]--;
        }
        for (int j : reserve) {
            status[j]++;
        }
        for (int i = 1; i < status.length; i++) {
            if(status[i-1] == 0 && status[i] > 1){
                status[i-1]++;
                status[i]--;
            }else{
                if(i+1 < status.length && status[i+1] == 0 && status[i] > 1){
                    status[i+1]++;
                    status[i]--;
                }
            }
        }

        for(int i : status){
            if(i > 0){
                answer++;
            }
        }

        return answer-1;
    }
}
