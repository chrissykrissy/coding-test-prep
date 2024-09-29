package coding.프로그래머스.고득점kit.해시;

import java.util.*;

public class 의상 {
    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for(String[] s : clothes){
            map.put(s[1], map.getOrDefault(s[1], 1)+1);
        }

        for(String k : map.keySet()){
            answer *= map.get(k);
        }

        answer -= 1;

        return answer;
    }

    public static void main(String[] args) {
        String[][] c = new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(c));
    }
}
