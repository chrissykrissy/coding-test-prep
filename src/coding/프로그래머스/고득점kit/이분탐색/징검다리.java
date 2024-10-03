package coding.프로그래머스.고득점kit.이분탐색;

import java.util.Arrays;

class 징검다리 {
    public int solution(int goal, int[] rocks, int n) {
        Arrays.sort(rocks);

        int left = 0;
        int right = goal;

        int result = Integer.MIN_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            int prev = 0;

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    cnt++;
                } else {
                    prev = rocks[i];
                }
                if (cnt > n) {
                    break;
                }
            }

            if (goal - prev < mid && cnt <= n) {
                cnt++;
            }
            if (cnt > n) {
                right = mid - 1;
            } else {
                left = mid + 1;

                result = mid;
            }
        }
        return result;
    }

    public int solution2(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);

        int left = 1;
        int right = distance;
        while(left <= right){
            int mid = (left + right)/2;
            if(getRemovedRockCnt(rocks, mid, distance) <= n){
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public int getRemovedRockCnt(int[] rocks, int mid, int distance){
        // mid가 바위(지점) 간 최소 거리가 되어야 함
        // 그렇게 하기 위해 제거 해야할 바위의 개수를 리턴한다.
        int before = 0;
        int end = distance;

        int removeCnt = 0;
        for(int i = 0; i < rocks.length; i++){
            if(rocks[i] - before < mid) {
                removeCnt++;
                continue;
            }
            before = rocks[i];
        }
        if(end - before < mid) removeCnt++;

        return removeCnt;
    }

}
