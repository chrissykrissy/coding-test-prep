package coding.프로그래머스.고득점kit.정렬;

import java.util.Arrays;

public class k번째수 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int c = 0; c < commands.length; c++) {
            int i = commands[c][0]-1;
            int j = commands[c][1];
            int k = commands[c][2]-1;

            int[] curr = Arrays.copyOfRange(array, i, j);
            Arrays.sort(curr);
            answer[c] = curr[k];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2,5,3}, {4,4,1}, {1,7,3}};
        System.out.println(Arrays.toString(solution(array, commands)));
    }

}
