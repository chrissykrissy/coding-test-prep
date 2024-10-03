import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min = 0;
        
        for(int max = people.length-1; max >= min; max--){
            if(people[max] + people[min] <= limit){
                answer++;
                min++;
            }else{
                answer++;
            }
        }
        return answer;
    }
}