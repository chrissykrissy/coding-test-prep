package coding.LeetCode;

public class Q408ValidWordAbbrev {
    public static boolean validWordAbbreviation(String word, String abbr) {

        int w = 0;
        int num = 0;
        for (char c : abbr.toCharArray()){
            if(c == '0' && num == 0) return false;
            if(Character.isDigit(c)){
                num = num * 10 + (c-'0');
            }
            else{
                w+=num;
                if(w >= word.length() || c != word.charAt(w)) return false;
                num = 0;
                w++;
            }
        }
        return w + num == word.length();
    }

    public static void main(String[] args) {
//        System.out.println(validWordAbbreviation("substitution", "s10n"));
        System.out.println(validWordAbbreviation("substitution", "sub4u4"));
    }
}