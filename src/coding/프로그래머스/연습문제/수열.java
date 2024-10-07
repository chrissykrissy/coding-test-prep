package coding.프로그래머스.연습문제;

import java.util.*;

public class 수열 {
    public static int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

//        for (int i = 0; i < elements.length; i++) {
//            int sum = 0;
//            for (int j = 0; j < elements.length; j++) {
//                sum += elements[(i+j)%elements.length];
//                set.add(sum);
//            }
//        }

        for (int len = 1; len <= elements.length; len++) {
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int j = i; j < i+len; j++) {
                    sum += elements[j%elements.length];
                }
                set.add(sum);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7,9,1,1,4}));
    }
}
