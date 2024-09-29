package coding.프로그래머스.고득점kit.해시;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for(String c : completion){
            map.put(c, map.get(c)-1);
        }

        for(String p : participant){
            if(map.get(p) != 0) return p;
        }
        return "";
    }
}
