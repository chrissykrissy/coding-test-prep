package coding.프로그래머스.연습문제;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 호텔방배정 {
    public static long[] TreeMapSolution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        TreeMap<Long, Long> map = new TreeMap<>();
        for(long i = 0; i < k; i++){
            map.put(i, i);
        }
        for (long i = 0; i < room_number.length; i++) {
            long ceil = map.ceilingKey(room_number[(int) i]);
            answer[(int) i] = ceil;
            map.remove(ceil);
        }

        return answer;
    }

    static Map<Long, Long> parent = new HashMap<>();
    public static long[] solution(long k, long[] room_number){
        long[] answer = new long[room_number.length];
        for(int i = 0; i < room_number.length; i++){
            answer[i] = find(room_number[i]);
        }
        return answer;
    }

    private static long find(long room) {
        if(!parent.containsKey(room)){
            parent.put(room, room+1);
            return room;
        }
        long nextRoom = find(parent.get(room));
        parent.put(room, nextRoom);
        return nextRoom;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, new long[]{1, 3, 4, 1, 3, 1})));
    }
}
