package coding.LeetCode;

public class Q129SumRootToLeafNumbers {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
//    public int sumNumbers(TreeNode root) {
//        return toLeaf(root, 0);
//    }
//    private int toLeaf(TreeNode root, int sum){
//        if(root == null) return;
//        if(root.left == null && root.right == null){
//            return sum*10 + root.val;
//        }
//        return toLeaf(root.left, sum*10 + root.val) +
//                toLeaf(root.right, sum*10 + root.val);
//    }
}
