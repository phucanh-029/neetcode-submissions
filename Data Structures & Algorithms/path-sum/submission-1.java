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
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)return false;
        Stack<TreeNode> stk = new Stack<>();
        Stack<Integer> stkSum = new Stack<>();
        stk.push(root);
        stkSum.push(targetSum-root.val);
        while(!stk.isEmpty()){
            TreeNode curr = stk.pop();
            Integer currSum = stkSum.pop();
            if(curr.left == null && curr.right == null && currSum == 0){
                return true;
            }
            if(curr.left!=null){
                stk.push(curr.left);
                stkSum.push(currSum - curr.left.val);
            }
            if(curr.right!=null){
                stk.push(curr.right);
                stkSum.push(currSum - curr.right.val);
            }
        }
        return false;
    }
}