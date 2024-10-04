package coding.프로그래머스.고득점kit.그리디;

import java.util.*;

public class 구명보트 {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min = 0;

        for(int max = people.length-1; max >= min; max--){
            if(people[max] + people[min] <= limit){
                answer++;
                min++;
            }else{
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 50, 80}, 100));
    }
}
