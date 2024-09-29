package coding.프로그래머스.고득점kit.스택큐;

import java.util.*;

public class 기능개발 {

    static class Work{
        int prog;
        int speed;
        int daysToFinish;

        public Work(int prog, int speed) {
            this.prog = prog;
            this.speed = speed;
            this.daysToFinish = (int) Math.ceil((100 - (double) prog) / (double) speed);
        }
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Work> list = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            Work w = new Work(progresses[i], speeds[i]);
            list.add(w);
        }

        List<Integer> answer = new ArrayList<>();
        while(!list.isEmpty()){
            int current = list.peek().daysToFinish;
            int numWork = 0;
            while(list.peek()!= null && current >= list.peek().daysToFinish){
                Work w = list.poll();
                current = Math.max(current, w.daysToFinish);
                numWork++;
            }
            answer.add(numWork);
        }
        return answer.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        int[] prog = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] prog2 = {95, 90, 99, 99, 80, 99};
        int[] sp2 = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(prog, speeds)));
        System.out.println(Arrays.toString(solution(prog2, sp2)));
    }
}
