package coding.boj;

import java.io.*;
public class 부분문자열 {
    static int[] table;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String p = br.readLine();

        bw.write(String.valueOf(KMP(s,p)));

        bw.flush();
    }

    public static int KMP(String s, String p){
        makeTable(p);
        int sLength = s.length();
        int pLength = p.length();

        int idx = 0;
        for (int i = 0; i < sLength; i++) {
            while(idx > 0 && s.charAt(i) != p.charAt(idx)){
                idx = table[idx-1];
            }
            if(s.charAt(i) == p.charAt(idx)){
                if(idx == pLength-1){
                    idx = table[idx];
                    return 1;
                }else{
                    idx+=1;
                }
            }
        }
        return 0;
    }

    public static void makeTable(String pattern){
        int pLen = pattern.length();
        table = new int[pLen];
        int index = 0;
        for (int i = 1; i < pLen; i++) {
            while (index > 0 && pattern.charAt(i) != pattern.charAt(index)) {
                index = table[index - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(index)) {
                index += 1;
                table[i] = index;
            }
        }
    }
}
