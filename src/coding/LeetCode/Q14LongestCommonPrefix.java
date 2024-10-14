package coding.LeetCode;

import java.util.Arrays;

public class Q14LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            if(strs[0].charAt(i) == strs[strs.length-1].charAt(i)){
                sb.append(strs[0].charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }
}
