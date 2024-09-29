package coding.프로그래머스.고득점kit.해시;

import java.util.*;

public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for(String s : set){
            for (int i = 0, j = 0; i < s.length(); i++) {
                if(set.contains(s.substring(j,i))){
                    return false;
                }
            }
        }

        return true;
    }
}
