package coding.프로그래머스.고득점kit.깊이너비우선탐색;

import java.util.*;

public class 단어변환 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        //words 안에 target 이 있는지 체크
        //최단경로이기 때문에 bfs 사용이 용이해보임
        //begin 에서 하나만 바꾼 단어가 target 에 있는지 확인

        Queue<String> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        q.offer(begin);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String current = q.poll();
                if(current.equals(target)){
                    return answer;
                }
                for (int j = 0; j < words.length; j++) {
                    if(!visited[j] && canConvert(current, words[j])){
                        visited[j] = true;
                        q.offer(words[j]);
                    }
                }
            }
            answer++;
        }


        return 0;
    }

    private boolean canConvert(String s1, String s2){
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }
}
