package coding.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q199BinarytreeRightSideView {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
//    public List<Integer> rightSideView(TreeNode root) {
//        //explore right leaf first
//        List<Integer> right = new ArrayList<>();
//        dfs(root, right, 0);
//        return right;
//    }
//
//    public void dfs(TreeNode root, List<Integer> right, int level) {
//        if (root == null) return;
//        if (level == right.size()) {
//            right.add(root.val);
//        }
//        dfs(root.right, right, level + 1);
//        dfs(root.left, right, level + 1);
//    }
//
//    public List<Integer> rightSideViewBFS(TreeNode root) {
//        List<Integer> ret = new ArrayList<>();
//        Queue<TreeNode> rv = new LinkedList<>();
//        if (root == null) {
//            return ret;
//        }
//        rv.add(root);
//        while (!rv.isEmpty()) {
//            int size = rv.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode n = rv.poll();
//                if (i == size - 1) {
//                    ret.add(n.val);
//                }
//                if (n.left != null) q.add(n.left);
//                if (n.right != null) q.add(n.right);
//            }
//        }
//        return ret;
//    }
}
