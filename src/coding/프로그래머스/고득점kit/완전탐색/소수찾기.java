package coding.프로그래머스.고득점kit.완전탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 소수찾기 {
    public static int solution(String numbers) {
        int answer = 0;
        String[] str = numbers.split("");
        List<Integer> allComb = new ArrayList<>();
        permute(str, new ArrayList<>(), allComb);
        for(Integer i : allComb){
            if(i == 1 || i == 2){
                answer++;
                break;
            }
            else if (i % 2 == 1 && i%3 != 0){
                answer++;
            }
        }

        return answer;
    }
    private static void permute(String[] str, List<String> temp, List<Integer> allComb){
        if(temp.size() == str.length){
            allComb.add(Integer.parseInt(String.join("",temp)));
        }else{
            for (int i = 0; i < str.length; i++) {
                if(temp.contains(str[i])) continue;
                temp.add(str[i]);
                permute(str, temp, allComb);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "17";
        String s2 = "011";
        System.out.println(solution(s));
        System.out.println(solution(s2));
    }
}
