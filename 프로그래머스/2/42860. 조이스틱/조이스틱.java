class Solution {
    public int solution(String name) {
        /*
        최적의 선택
        1. 바꿔줘야 하는 알파벳이 N 까지 사이면 up, || down
        2. 바꿔줘야하는 다음 알파벳의 위치가 <- 랑 ->랑 비교했을때 더 가까운 곳으로
         */
        int answer = 0;
        int move = name.length()-1; //오른쪽으로 쭉 간 횟수

        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i)-'A', 26-(name.charAt(i)-'A'));
            if(i < name.length()-1 && name.charAt(i+1) == 'A'){
                int endA = i+1; //A가 끝나는 지점을 저장, 그 지점까지 이동하는 값 비교
                while(endA < name.length() && name.charAt(endA) == 'A'){
                    endA++;
                }
                move = Math.min(move, i*2+(name.length() - endA)); //오른쪽으로 갔다 다시 왼쪽으로 꺾기
                move = Math.min(move, i + (name.length() - endA) * 2); //왼쪽으로 갔다 다시 오른쪽으로 꺾기
            }
        }
        return answer + move;
    }
}