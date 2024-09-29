package coding.프로그래머스.고득점kit.해시;

import java.util.HashMap;
import java.util.Map;

public class 폰캣몬 {
    public int solution(int[] nums) {
        int total = nums.length;
        //k-type v-count
        Map<Integer, Integer> mon = new HashMap<>();
        for(int i : nums){
            mon.put(i, mon.getOrDefault(i, 0)+1);
        }

        int get = total/2;
        if(mon.size() >= get){
            return get;
        }else{
            return mon.size();
        }
    }
}
