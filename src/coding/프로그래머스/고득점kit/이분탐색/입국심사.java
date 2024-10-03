package coding.프로그래머스.고득점kit.이분탐색;

import java.util.*;
class 입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;

        //최악의 시간은 마지막 시간*n
        long right = (long) times[times.length-1]*n;
        long answer = 0;
        while(left <= right){
            long complete = 0;
            long mid = (left + right)/2;

            for(int t : times){
                complete += mid/t;
            }

            if(complete >= n){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return answer;
    }
}