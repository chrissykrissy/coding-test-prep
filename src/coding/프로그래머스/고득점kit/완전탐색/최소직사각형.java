package coding.프로그래머스.고득점kit.완전탐색;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int max1 = 0;
        int max2 = 0;

        for(int[] i : sizes){
            int f = Math.max(i[0], i[1]);
            int s = Math.min(i[0], i[1]);

            max1 = Math.max(f, max1);
            max2 = Math.max(s, max2);
        }
        return max1 * max2;
    }
}
