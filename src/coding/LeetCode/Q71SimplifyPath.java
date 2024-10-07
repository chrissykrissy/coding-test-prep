package coding.LeetCode;

import java.util.Stack;

public class Q71SimplifyPath {
    public String simplifyPath(String path) {
        String[] ori = path.split("/");
        Stack<String> dir = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ori.length; i++) {
            String curr = ori[i];
            //if up a directory
            if(!dir.isEmpty() && curr.equals("..")){
                dir.pop();
            }else if (!curr.equals("") && !curr.equals(".") && !curr.equals("..")){
                dir.push(curr);
            }
        }
        if(dir.isEmpty()) return "/";
        while(!dir.isEmpty()){
            sb.insert(0, dir.pop()).insert(0, "/");
        }
        return sb.toString();
    }
}
