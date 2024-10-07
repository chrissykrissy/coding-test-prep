package coding.LeetCode;

import java.util.*;

public class Q314BTVeritcalOrderTraversal {
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
     }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList();
        TreeMap<Integer, List<Integer>> col = new TreeMap<>();
        Queue<TreeNode> treeq = new LinkedList<>();
        Queue<Integer> colq = new LinkedList<>();
        treeq.add(root);
        colq.add(0);
        while(!treeq.isEmpty() && !colq.isEmpty()){
            TreeNode curr = treeq.poll();
            int currCol = colq.poll();
            if(!col.containsKey(currCol)){
                col.put(currCol, new ArrayList<>());
            }
            col.get(currCol).add(curr.val);
            if(curr.left != null){
                treeq.add(curr.left);
                colq.add(currCol-1);
            }
            if(curr.right != null){
                treeq.add(curr.right);
                colq.add(currCol+1);
            }
        }


        List<List<Integer>> ret = new ArrayList<>();
        for(Integer i : col.keySet()){
            ret.add(col.get(i));
        }
        return ret;
    }
}
