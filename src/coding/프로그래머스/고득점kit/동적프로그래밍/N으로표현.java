package coding.프로그래머스.고득점kit.동적프로그래밍;

import java.util.*;

import java.util.*;
class N으로표현 {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        //각 통의 인덱스는 총 쓰여진 숫자의 갯수
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }
        dp.get(1).add(N);
        if(N == number) return 1;

        //다음통 = 전 두통 합치기 + 통의 인덱스길이만큼쓰인 N
        for (int i = 2; i < 9; i++) {
            Set<Integer> result = dp.get(i);
            for (int j = 1; j < i; j++) {
                //괄호때문에 1+2 , 2+1 둘 다 더해줘야함
                Set<Integer> pre = dp.get(j);
                Set<Integer> post = dp.get(i-j);
                for(int preN : pre){
                    for(int postN : post){
                        result.add(preN + postN);
                        result.add(preN - postN);
                        result.add(preN * postN);
                        if(preN != 0 && postN != 0){
                            result.add(preN/postN);
                        }

                    }
                }
                result.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }
            if(result.contains(number)) return i;
        }

        return -1;
    }
}
