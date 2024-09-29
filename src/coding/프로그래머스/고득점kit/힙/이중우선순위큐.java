package coding.프로그래머스.고득점kit.힙;

import java.util.*;
public class 이중우선순위큐 {
    public static int[] solution(String[] operations) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minHeap = new PriorityQueue<>();

        for(String s : operations){
            if(s.startsWith("I")){
                int add = Integer.parseInt(s.substring(1).strip());
                minHeap.offer(add);
                maxHeap.offer(add);
            }else if (!minHeap.isEmpty()) {
                if(s.equals("D 1")){
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                }else{
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }

        return maxHeap.isEmpty() && minHeap.isEmpty() ? new int[]{0,0} : new int[]{maxHeap.peek(), minHeap.peek()};
    }

    public static void main(String[] args) {
        String[] s = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] s2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(solution(s)));
        System.out.println(Arrays.toString(solution(s2)));
    }
}
