package coding.LeetCode;

import java.util.Random;

public class Q528RandomPickWWeight {
    int[] sum;
    Random rand;
    public Q528RandomPickWWeight(int[] w) {
        sum = new int[w.length];
        rand = new Random();
        for(int i = 0; i < w.length; i++){
            if(i == 0) sum[i] = w[i];
            else{
                sum[i] = sum[i-1]+w[i];
            }
        }
    }

    public int pickIndex() {
        int len = sum.length;
        int idx = rand.nextInt(len-1)+1;
        int left = 0, right = len-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(sum[mid] == idx) return mid;
            else if (sum[mid] < idx){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
