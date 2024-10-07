package coding.boj;

public class 부분문자열KMP_practice {
    static int[] pi;
    public static void makeTable(String pattern){
        pi = new int[pattern.length()];
        int idx = 0;
        for (int i = 1; i < pattern.length(); i++) {
            //전에 똑같은 문자열이 있을 경우 채워 넣어야함 예) ababc => [0, 0, 1, 2, 0]
            while(idx > 0 && pattern.charAt(idx) != pattern.charAt(i)){
                idx = pi[idx-1];
            }
            if(pattern.charAt(idx) == pattern.charAt(i)){
                idx++;
                pi[i] = idx;
            }
        }
    }

    public static int KMP(String s, String p){
        makeTable(p);
        int slen = s.length();
        int plen = p.length();
        int idx = 0;
        for (int i = 0; i < slen; i++) {
            while(idx > 0 && s.charAt(i) != p.charAt(idx)){
                idx = pi[idx-1];
            }
            if(s.charAt(i) == p.charAt(idx)){
                if(idx == plen-1){
                    idx = pi[idx];
                    return 1;
                }else{
                    idx++;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //makeTable("ababc");
        makeTable("abcaaabcde"); // [0,0,0,1,1,1,2,3,0,0]
    }
}
