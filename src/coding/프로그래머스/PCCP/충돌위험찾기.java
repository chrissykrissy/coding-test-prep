package coding.프로그래머스.PCCP;

import java.util.*;

public class 충돌위험찾기 {

    private static class Robot{
        private int r;
        private int c;
        private int nextStop;

        public Robot(int r, int c, int nextStop){
            this.r = r;
            this.c = c;
            this.nextStop = nextStop;
        }
        public void moveToTarget(int targetR, int targetC){
            if(r < targetR){
                r++;
                return;
            }else if(r > targetR){
                r--;
                return;
            }
            if(c < targetC){
                c++;
            }else if (c > targetC){
                c--;
            }
        }

        public boolean hasArrived(int targetR, int targetC){
            return r == targetR && c == targetC;
        }
        public void stopPlus(){
            nextStop++;
        }
    }

    public static int solution(int[][] points, int[][] routes) {
        int routeNum = routes[0].length; //총 경유지의 갯수
        List<Robot> robots = new ArrayList<>();
        Map<Integer, Integer> startCollision = new HashMap<>();
        for(int[] route : routes){
            int startPoint = route[0] - 1;
            int r = points[startPoint][0];
            int c = points[startPoint][1];
            robots.add(new Robot(r, c, 1));
            startCollision.merge(route[0], 1, Integer::sum);
        }
        int result = 0;
        for(Integer v : startCollision.values()){
            if(v > 1){
                result++; //초기 시작 위치 충돌 체크
            }
        }

        while(!robots.isEmpty()){
            Map<String, Integer> collisionMap = new HashMap<>();
            boolean[] arrived = new boolean[robots.size()];
            for (int i = 0; i < robots.size(); i++) {
                Robot robot = robots.get(i);
                int nextStop = robot.nextStop;
                if(nextStop >= routeNum){
                    arrived[i] = true;
                    continue;
                }
                int pointIndex = routes[i][nextStop]-1;
                int targetR = points[pointIndex][0];
                int targetC = points[pointIndex][1];

                robot.moveToTarget(targetR, targetC);

                String posKey = robot.r + " " + robot.c;
                collisionMap.merge(posKey, 1, Integer::sum);

                if (robot.hasArrived(targetR, targetC)) {
                    robot.stopPlus();
                }
            }
            for(Integer v : collisionMap.values()){
                if(v > 1){
                    result++;
                }
            }
            boolean allArrived = true;
            for (boolean arriveStatus : arrived) {
                if(!arriveStatus){
                    allArrived = false;
                    break;
                }
            }
            if(allArrived){
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{3,2},{6,4},{4,7},{1,4}}, new int[][]{{4,2}, {1,3}, {2,4}}));
    }
}