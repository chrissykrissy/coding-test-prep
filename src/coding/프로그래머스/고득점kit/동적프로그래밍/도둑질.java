package coding.프로그래머스.고득점kit.동적프로그래밍;

public class 도둑질 {
    public int solution(int[] money) {
        //동그랗게 배치되어 있기때문에, 시작점을 다르게 해서 구해야함
        int[] rob1 = new int[money.length]; //첫번째 집에서 시작
        int[] rob2 = new int[money.length]; //두번째 집에서 시작

        rob1[0] = 0;
        rob2[0] = 0;

        rob1[1] = money[0];
        rob2[1] = money[1];

        for(int i = 1; i < money.length-1; i++){
            //도둑은 1. 전 집만 훔치거나
            //2. 전전 집 + 현재집을 훔친것에 만족해야함 (더 클 경우)
            rob1[i+1] = Math.max(rob1[i], rob1[i-1]+money[i]);
        }

        for(int i = 2; i < money.length; i++){
            rob2[i] = Math.max(rob2[i-1], rob2[i-2]+money[i]);
        }

        return Math.max(rob1[money.length-1], rob2[money.length-1]);
    }
}
