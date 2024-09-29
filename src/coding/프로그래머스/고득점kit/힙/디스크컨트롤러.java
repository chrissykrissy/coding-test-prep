package coding.프로그래머스.고득점kit.힙;

import java.util.*;

public class 디스크컨트롤러 {
    static class Disk{
        int request;
        int duration;
        int end;

        public Disk(int request, int duration) {
            this.request = request;
            this.duration = duration;
            this.end = request + duration;
        }

        public int getRequest() {
            return request;
        }

        public int getDuration() {
            return duration;
        }

        public int getEnd() {
            return end;
        }
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        int end = 0;
        int jobIdx = 0;
        int count = 0;

        //요청시간부터 종료까지 가장 짧게 배치하려면 수행시간이 짧은 작업부터 처리해야함
        //하나의 작업이 끝나는 시점까지 들어온 요청에 대해서 가장 짧은 수행 시간을 가진 작업을 선택

        //원본 배열 오름차순 정렬 (요청시간 오름차순)
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        //처리 시간 오름차순
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        //요청이 모두 수행될 떄 까지 반복
        while(count < jobs.length){
            //하나의 작업이 완료되는 시점(end) 까지 들어온 모든 요청을 큐에 넣음
            while(jobIdx < jobs.length && jobs[jobIdx][0] <= end){
                pq.offer(jobs[jobIdx++]);
            }
            //큐가 비어있다면 작업완료 이후에 다시 요청이 들어온다는 의미
            //end 를 요청의 가장 처음으로 맞춰줌
            if(pq.isEmpty()){
                end = jobs[jobIdx][0];
            }
            //작업이 끝나기 전 들어온 요청중 가장 수행 시간이 짧은 요청부터 수행
            else{
                int[] tmp = pq.poll();
                answer += tmp[1] + end - tmp[0];
                end += tmp[1];
                count++;
            }
        }

        return (int) Math.floor(answer/jobs.length);
    }

    public static void main(String[] args) {
        int[][]d = new int[][]{{0,3}, {1,9}, {2,6}};
        int[][] d2 = new int[][] {{0,1}, {0,2}, {1,6}};
        int[][] d3 = new int[][] {{5,10}, {6, 8}, {14,2}, {11,5}, {100, 7}};
        int[][] d4 = new int[][] {{0,1}, {2,2}, {2,3}};
        int[][] d5 = new int[][] {{0,3}, {4,4}, {5,3}, {7,1}};
        System.out.println(solution(d)); //9
        System.out.println(solution(d2)); //4
        System.out.println(solution(d3)); //11
        System.out.println(solution(d4)); //2
        System.out.println(solution(d5)); //4
    }
}
