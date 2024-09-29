package coding.프로그래머스.고득점kit.완전탐색;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;

        //1채점
        int[] a1 = new int[]{1, 2, 3, 4, 5},
                a2 = new int[]{2,1,2,3,2,4,2,5},
                a3 = new int[]{3,3,1,1,2,2,4,4,5,5};
        for (int i = 0; i < answers.length; i++) {
            //1채점
            if(i < a1.length){
                if(a1[i] == answers[i]) c1++;
            }else{
                if(a1[i%a1.length] == answers[i]) c1++;
            }

            //2채점
            if(i < a2.length){
                if(a2[i] == answers[i]) c2++;
            }else{
                if(a2[i%a2.length] == answers[i]) c2++;
            }

            //3채점
            if(i < a3.length){
                if(a3[i] == answers[i]) c3++;
            }else{
                if(a3[i%a3.length] == answers[i]) c3++;
            }
        }
        int max = Math.max(Math.max(c1,c2), c3);
        ArrayList<Integer> ret = new ArrayList<>();
        if(max == c1){
            ret.add(1);
        }
        if(max == c2){
            ret.add(2);
        }
        if(max == c3){
            ret.add(3);
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}
