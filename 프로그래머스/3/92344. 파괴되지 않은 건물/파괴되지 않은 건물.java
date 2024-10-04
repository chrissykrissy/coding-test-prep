import java.util.*;
class Solution {
        public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] calc = new int[board.length+1][board[0].length+1];
        for(int[] s : skill){
            //[type, r1, c1, r2, c2, degree]
            int type = s[0]; int degree = s[5];
            int r1 = s[1]; int c1 = s[2];
            int r2 = s[3]; int c2 = s[4];
            //공격
            if(type == 1){
                degree = -degree;
            }
            calc[r1][c1] += degree;
            calc[r1][c2+1] += -degree;
            calc[r2+1][c1] += -degree;
            calc[r2+1][c2+1] += degree;
        }
            

        for (int i = 1; i < calc.length; i++) {
            for (int j = 0; j < calc[i].length; j++) {
                calc[i][j] += calc[i-1][j];
            }
        }

        for (int i = 0; i < calc.length; i++) {
            for (int j = 1; j < calc[i].length; j++) {
                calc[i][j] += calc[i][j-1];
            }
        }
        

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] += calc[i][j];
            }
        }
        

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] > 0) answer++;
            }
        }


        return answer;
    }
}