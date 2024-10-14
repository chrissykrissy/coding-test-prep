package coding.프로그래머스.연습문제;

public class N1카드게임 {
    public int solution(int coin, int[] cards) {
        int answer = 1;
        int n = cards.length;
        boolean[] hand = new boolean[n+1]; //손패에 카드가 있는지
        boolean[] free = new boolean[n+1]; //공짜 카드인지
        int coinLeft = coin;

        //처음카드뽑기
        for (int i = 0; i < n/3; i++) {
            hand[cards[i]] = true;
            free[cards[i]] = true;
        }

        for (int i = n/3; i < n; i+=2) {
            if (coinLeft > 0){
                hand[cards[i]] = true;
                hand[cards[i+1]] = true;
            }

            boolean pass = false; //낼 수 있는 카드 쌍이 있는지
            int minCost = 3; //최소비용, 나올 수 있는 가장 큰 비용이 2므로 3으로 초기화
            int trash = -1; //버릴카드
            for (int j = 1; j <= n; j++) {
                if (!hand[j]) { //손패에 있는지
                    continue;
                }
                if (hand[n + 1 - j]) { //비용 감당되는지
                    int cost = (free[j] ? 0 : 1) + (free[n + 1 - j] ? 0 : 1);
                    if (coinLeft < cost || minCost <= cost) {
                        continue;
                    }
                    pass = true;
                    trash = j;
                    minCost = cost;
                }
            }

            if(!pass){ //버릴카드 없으면 끝
                break;
            }

            hand[trash] = false;
            hand[n+1-trash] = false;
            coinLeft -= minCost;
            answer++;
        }
        return answer;
    }
}
