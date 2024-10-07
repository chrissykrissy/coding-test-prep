package coding.LeetCode;

import java.util.Stack;

public class Q227BasicCalculator2 {
    public int calculate(String s) {
        int sum = 0;
        int curr = 0;
        int prev = 0;
        char opp = '+';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + (c-'0');
            }
            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length()-1){
                if(opp == '+'){
                    sum+= prev;
                    prev = curr;
                }else if (opp == '-'){
                    sum+= prev;
                    prev = -curr;
                }else if (opp == '*'){
                    prev = prev * curr;
                }else if(opp == '/'){
                    prev = prev/curr;
                }
                opp = c;
                curr = 0;
            }
        }
        return sum+prev;
    }
//    public int calculate2(String s){
//        Stack<Integer> nums = new Stack<>();
//        Stack<Character> opp = new Stack<>();
//        int num = 0;
//        for(char c : s.toCharArray()){
//            if(Character.isDigit(c)){
//                num = num * 10 + (c - '0');
//                if(!opp.isEmpty()) {
//                    if (opp.peek() == '/' || opp.peek() == '*') {
//                        int top = num;
//                        int before = nums.pop();
//                        if (opp.peek() == '/') {
//                            nums.push(before / top);
//                            opp.pop();
//                        } else {
//                            nums.push(before * top);
//                            opp.pop();
//                        }
//                    }
//                }
//            }else{
//                nums.push(num);
//                opp.push(c);
//            }
//        }
//        while(!opp.isEmpty() && !nums.isEmpty()){
//            int top = nums.pop();
//            int before = nums.pop();
//            if(opp.peek() == '+'){
//                nums.push(top + before);
//            }else{
//                nums.push(before-top);
//            }
//        }
//        return nums.peek();
//    }

    public int calculate3(String s){
        int len = s.length();
        int curr = 0;
        char currOp = '+';
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + (c-'0');
            }
            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == len-1){
                if(currOp == '+'){
                    stk.push(curr);
                }else if (currOp == '-'){
                    stk.push(-curr);
                }else if (currOp == '*'){
                    stk.push(stk.pop()*curr);
                }else if(currOp == '/'){
                    stk.push(stk.pop()/curr);
                }
                currOp = c;
                curr = 0;
            }
        }
        int result = 0;
        while(!stk.isEmpty()){
            result += stk.pop();
        }
        return result;
    }
}
