package coding.LeetCode;

import java.util.Arrays;

public class Q680ValidPalindrome3 {
    public boolean validPalindrome(String s) {
        if(s.length() == 1) return false;
        char[] reverse = new char[s.length()];
        int j = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            reverse[j] = s.charAt(i);
            j++;
        }
        if(s.equals(Arrays.toString(reverse))) return true;

        int start = 0; int end = s.length()-1;
        while(start <= end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return (checkPart(s.substring(start, end)) || checkPart(s.substring(start+1, end+1)));
            }
        }
        return true;
    }

    private boolean checkPart(String s){
        int start = 0; int end = s.length()-1;
        while(start <= end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}
