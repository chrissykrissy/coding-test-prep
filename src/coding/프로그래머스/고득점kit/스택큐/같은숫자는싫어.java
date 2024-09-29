package coding.프로그래머스.고득점kit.스택큐;

import java.util.*;

public class 같은숫자는싫어 {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int prev = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != prev){
                list.add(arr[i]);
            }
            prev = arr[i];
        }

        return list.stream().mapToInt(x -> x).toArray();
    }
}
