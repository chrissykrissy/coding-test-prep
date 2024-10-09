package coding.LeetCode;

public class Q125ValidPalindrome {
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length()-1; i < j; i++, j--) {
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }

            if(Character.isLetterOrDigit(s.charAt(i)) && Character.isLetterOrDigit(s.charAt(j))){
                if(s.charAt(i) != s.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
