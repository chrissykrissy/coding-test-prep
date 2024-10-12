package coding.LeetCode;

import java.util.*;

class Q17LetterCombinationsOfaPhoneNumber {
    /*
  TC : O(4^N * N) ->
      4 is referring to the maximum value length in the hashmap
      we have to explore 4 additional paths for every extra digit and for each combination,
      costs up to N to build the combination
  SC : O(N)
  */
    static Map<String, String[]> map = new HashMap<>();
    public static List<String> letterCombinations(String digits) {
        //init
        map.put("2", new String[]{"a", "b", "c"});
        map.put("3", new String[]{"d", "e", "f"});
        map.put("4", new String[]{"g", "h", "i"});
        map.put("5", new String[]{"j", "k", "l"});
        map.put("6", new String[]{"m", "n", "o"});
        map.put("7", new String[]{"p", "q", "r", "s"});
        map.put("8", new String[]{"t", "u", "v"});
        map.put("9", new String[]{"w", "x", "y", "z"});

        List<String> ret = new ArrayList<>();
        if(digits.equals("")) return ret;
        String[] digit = digits.split("");
        allCombs(digit, 0, ret, new StringBuilder());
        return ret;
    }
    private static void allCombs(String[] digits, int index, List<String> ret, StringBuilder sb){
        //split the digit
        //add one from the map
        //produce comb
        //remove one that's added
        if(index >= digits.length || sb.length() == digits.length){
            ret.add(sb.toString());
            return;
        }
        for(int i = 0; i < map.get(digits[index]).length; i++){
            sb.append(map.get(digits[index])[i]);
            allCombs(digits, index + 1, ret, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations(""));
    }
}
