package coding.프로그래머스.연습문제;

import java.util.*;
public class 도넛과막대그래프 {
    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];
        //정점번호, 도넛모양수, 막대모양수, 8자모양수
        /*
        1. 각 노드별,
        경우 1) out == 0 : 직선 그래프 갯수 + 1
        경우 2) out == 1 : 흔한 노드.. 무시
        경우 3) out == 2 :
                    if in > 0 : 8자 그래프 갯수 += 1
                    else : 이 노드가 정점
        경우 4) out > 2 : 이 노드가 정점
        도넛갯수 = 정점 out - 막대 - 8자
         */
        //key is id, v = [inbound, outbound]
        Map<Integer, int[]> graph = new HashMap<>();

        for(int[] e : edges){
            int from = e[0];
            int to = e[1];
            if(!graph.containsKey(from)){
                graph.put(from, new int[2]);
            }
            if(!graph.containsKey(to)){
                graph.put(to, new int[2]);
            }
            graph.get(from)[1]++;
            graph.get(to)[0]++;
        }

        for(Integer n : graph.keySet()){
            if(graph.get(n)[1] == 0){
                answer[2]++;
            }
            else if(graph.get(n)[1] == 1) {
                continue;
            }
            else if(graph.get(n)[1] == 2){
                if(graph.get(n)[0] > 0){
                    answer[3]++;
                }else{
                    answer[0] = n;
                }
            }else{
                answer[0] = n;
            }
        }
        answer[1] = graph.get(answer[0])[1]-answer[2]-answer[3];

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{
                {2, 3},
                {4, 3},
                {1, 1},
                {2, 1}
        })));
        System.out.println(Arrays.toString(solution(new int[][]{
                {4, 11},
                {1, 12},
                {8, 3},
                {12, 7},
                {4, 2},
                {7, 11},
                {4, 8},
                {9, 6},
                {10, 11},
                {6, 10},
                {3, 5},
                {11, 1},
                {5, 3},
                {11, 9},
                {3, 8}
        })));
    }
}
