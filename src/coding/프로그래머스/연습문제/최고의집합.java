package coding.프로그래머스.연습문제;

import java.util.Arrays;
public class 최고의집합 {
    public static int[] solution(int n, int s) {
        int div = s/n;
        int mod = s%n;
        if(div == 0){
            return new int[]{-1};
        }else{
            int[] ret = new int[n];
            for (int i = 0; i < n-mod; i++) {
                ret[i]=div;
            }
            for (int i = n-mod; i < n; i++) {
                ret[i]=div+1;
            }
            return ret;
        }
    }



    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 9)));
        System.out.println(Arrays.toString(solution(2, 1)));
        System.out.println(Arrays.toString(solution(2, 8)));
    }
}
