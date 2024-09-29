package coding.프로그래머스.고득점kit.스택큐;

import java.util.*;
public class 주식가격 {
    public int[] mySolution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                answer[i]++;
                if(prices[i] > prices[j]){
                    break;
                }
            }
        }
        return answer;
    }

    public static int[] solution(int[] prices){
        int[] ans = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                ans[stack.peek()] = i - stack.peek();
                stack.pop(); // 답을 구했기 때문에 stack에서 제거한다
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) { // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
            ans[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] p = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(p)));
    }
}
