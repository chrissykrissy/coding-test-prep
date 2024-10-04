package coding.프로그래머스.고득점kit.그리디;

import java.util.*;
public class 단속카메라 {

    private static int[] parent;
    private static int size;

    public int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b){
        a = parent[a];
        b = parent[b];
        if(a != b){
            parent[b] = a;
            size--;
        }
    }

    public static int solution(int[][] routes) {
        int answer = 0;
        parent = new int[routes.length];
        size = routes.length;

        Arrays.sort(routes, (a, b) -> a[1]-b[1]);
        int curr = -30001;
        for(int[] i : routes){
            if(i[0] < curr){
                continue;
            }else{
                answer++;
                curr = i[1];
            }
        }

//        for (int i = 0; i < routes.length; i++) {
//            parent[i] = i;
//        }
//
//        for (int i = 1; i < routes.length; i++) {
//            //진입이 전진입보다 크고, 전진출보다 작음
//            if(routes[i][0] < routes[i-1][1]){
//                union(i-1, i);
//            }
//        }

        return answer;
        //return size;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5,-3}}));
        System.out.println(solution(new int[][]{{0,10}, {1,10}, {2,3}, {4,5}}));
    }
}
