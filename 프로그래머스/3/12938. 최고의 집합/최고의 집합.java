class Solution {
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
}