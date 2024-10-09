package coding.LeetCode;
public class Q938RangeSumBST {
//    int sum = 0;
//    public int rangeSumBST(TreeNode root, int low, int high) {
//        //if root is between range, must explore both sides
//        //if root is less than the low, explore right
//        //if root is greater than the high, explore left
//        explore(root, low, high);
//        return sum;
//    }
//
//    private void explore(TreeNode root, int low, int high){
//        if(root == null) return;
//        if(root.val >= low && root.val <= high){
//            sum += root.val;
//        }else if (root.val < low){
//            explore(root.right, low, high);
//        }else if(root.val > high){
//            explore(root.left, low, high);
//        }
//    }
//    public int rangeSumBST(TreeNode root, int low, int high) {
//        //if root is between range, must explore both sides
//        //if root is less than the low, explore right
//        //if root is greater than the high, explore left
//        if(root == null) return 0;
//        if(root.val < low){
//            rangeSumBST(root.right, low, high);
//        }
//        if(root.val > high){
//            rangeSumBST(root.left, low, high);
//        }
//        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
//    }
//
}
