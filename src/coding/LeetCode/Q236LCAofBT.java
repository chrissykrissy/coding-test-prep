package coding.LeetCode;

public class Q236LCAofBT {

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
         if(root == null || p == null || q == null) return root;
         TreeNode l = helper(root.left, p, q);
         TreeNode r = helper(root.right, p, q);
         if(l != null && r != null) return root;
         if(l == null) return r;
         else return l;
    }
    //could be one method
}
