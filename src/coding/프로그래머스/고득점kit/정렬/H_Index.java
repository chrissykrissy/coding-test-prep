package coding.프로그래머스.고득점kit.정렬;

import java.util.Arrays;
import java.util.Collections;

public class H_Index {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if(citations[i] >= h){
                return h;
            }
        }
        return 0;
    }
}
