import java.util.*;

class Solution {
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
}