package coding.프로그래머스.고득점kit.완전탐색;

import java.util.*;

public class 모음사전 {
    static List<String> dict;
    static String[] word = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        //word 까지 모든 단어 produce 하고 count
        dict = new ArrayList<>();
        dfs("", 0);
        System.out.println(dict.size());
        return dict.indexOf(word);
    }

    private void dfs(String s, int len) {
        dict.add(s);
        if(len == 5) return;
        for (int j = 0; j < 5; j++) {
            dfs(s+word[j], len+1);
        }
    }


    private void dfs2(String[] alph, List<String> dict, String word, String curr) {
        for (int i = 0; i < alph.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(alph[i]);
            dict.add(sb.toString());
            if(sb.toString().equals(word)) return;

        }
    }

}
