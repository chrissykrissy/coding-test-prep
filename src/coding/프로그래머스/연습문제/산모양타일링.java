package coding.프로그래머스.연습문제;

public class 산모양타일링 {
    public int solution(int n, int[] tops) {
        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = 1;
        b[0] = 2 + tops[0];
        for(int i = 1; i < n; i++){
            a[i] = (a[i-1]+b[i-1])%10007;
            b[i] = ((1+tops[i]) * a[i-1] + (2 + tops[i]) * b[i-1]) % 10007;
        }
        return a[n-1]+b[n-1];
    }
}
