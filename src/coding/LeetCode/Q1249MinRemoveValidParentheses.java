package coding.LeetCode;

import java.util.*;

public class Q1249MinRemoveValidParentheses {
    public static String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> open = new Stack<>();
        //Stack<Integer> close = new Stack<>();
        Set<Integer> remove = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                open.push(i);
            }else if (s.charAt(i) == ')'){
                if(!open.isEmpty()){
                    open.pop();
                }else{
                    remove.add(i);
                }
            }
        }
        while(!open.isEmpty()){
            remove.add(open.pop());
        }

        for (int i = 0; i < s.length(); i++) {
            if(!remove.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("))(("));
    }
}
