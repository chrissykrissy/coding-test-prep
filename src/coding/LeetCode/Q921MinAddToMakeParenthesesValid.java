package coding.LeetCode;

public class Q921MinAddToMakeParenthesesValid {
    public static int minAddToMakeValid(String S) {
        int open = 0;
        int close = 0;
        for (char c : S.toCharArray()) {
            if(c == '('){
                open++;
            } else if (open > 0){
                open--;
            }
            else{
                close++;
            }
        }
        return open+close;
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())"));
        System.out.println(minAddToMakeValid("((("));
        System.out.println(minAddToMakeValid("((("));
    }
}
