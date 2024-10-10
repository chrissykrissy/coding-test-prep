class Solution {
    public String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] arr = s.split(" ");
        for(String num : arr){
            int val = Integer.parseInt(num);
            max = Math.max(max, val);
            min = Math.min(min, val);
        }
        return min+" "+max;
    }
}