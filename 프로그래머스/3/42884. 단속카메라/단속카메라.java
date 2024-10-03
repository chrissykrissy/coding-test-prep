import java.util.*;
class Solution {
        public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> a[1]-b[1]);
        int curr = -30001;
        for(int[] i : routes){
            if(i[0] <= curr){
                continue;
            }else{
                answer++;
                curr = i[1];
            }
        }
        return answer;
    }
}