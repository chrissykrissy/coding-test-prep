package coding.프로그래머스.고득점kit.스택큐;

import java.util.*;

public class 올바른괄호 {
    static boolean solution(String s) {
        Stack<String> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stk.push(")");
            }else{
                if(!stk.isEmpty()){
                    stk.pop();
                }else{
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        String s4 = "(()(";
        String s5 = ")))";
        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
        System.out.println(solution(s5));
    }
}
