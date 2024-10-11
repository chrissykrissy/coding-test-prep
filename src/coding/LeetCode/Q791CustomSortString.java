package coding.LeetCode;

public class Q791CustomSortString {
    public String customSortString(String order, String s) {
        int[] alph = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            alph[c-'a']++;
        }
        for(char c : order.toCharArray()){
            if(alph[c-'a'] > 0){
                sb.append(c);
                alph[c-'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if(alph[i] > 0){
                sb.append((char)('a'+i));
            }
        }


        String[] sArr = s.split("");
        //StringBuilder sb = new StringBuilder();
        if(s.contains(order)){
            sb.append(order);
        }
        for (int i = 0; i < sArr.length; i++) {
            if(!order.contains(sArr[i])){
                sb.append(sArr[i]);
            }
        }
        return sb.toString();
    }
}
