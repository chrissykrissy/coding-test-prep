import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        //이번달까지 더 많이 준 사람이 다음달 +1
        //기록이 없거나 같으면 선물 지수가 더 큰 사람이 작은 사람에게
        //다음달에 선물을 가장 많이 받을 친구가 받을 선물의 수
        Map<String, Integer> friends_id = new HashMap<>();
        for(int i = 0; i < friends.length; i++){
            friends_id.put(friends[i], i);
        }

        int[][] giveTake = new int[friends.length][friends.length];
        int[][] calcGiftIndex = new int[friends.length][3]; //give, get, index
        for(int i = 0; i < gifts.length; i++){
            String[] fromTo = gifts[i].split(" ");
            giveTake[friends_id.get(fromTo[0])][friends_id.get(fromTo[1])]++;
            calcGiftIndex[friends_id.get(fromTo[0])][0]++;
            calcGiftIndex[friends_id.get(fromTo[1])][1]++;
        }
        for(int i = 0; i < friends.length; i++){
            calcGiftIndex[i][2] = calcGiftIndex[i][0]-calcGiftIndex[i][1];
        }

        int[] giftList = new int[friends.length];
        for(int i = 0; i < friends.length; i++){
            for(int j = 0; j < friends.length; j++){
                if(i != j){
                    if(giveTake[i][j] > giveTake[j][i]){
                        giftList[i]++;
                    }else if (giveTake[i][j] == giveTake[j][i] || (giveTake[i][j] == 0 && giveTake[j][i] == 0)){
                        if(calcGiftIndex[i][2] > calcGiftIndex[j][2]){
                            giftList[i]++;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < giftList.length; i++){
            answer = Math.max(answer, giftList[i]);
        }

        return answer;
    }
}