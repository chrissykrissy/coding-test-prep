package coding.프로그래머스.고득점kit.완전탐색;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int yh = 1; yh <= yellow; yh++) {
            if(yellow%yh == 0){
                int bh = yh+2;
                int bw = (yellow / yh) + 2;
                if((bh * bw) - yellow == brown){
                    return new int[]{bw, bh};
                }
            }
        }
        return answer;
    }
}
