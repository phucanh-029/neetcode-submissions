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
    public boolean isValidBST(TreeNode root) {
        if(root == null ) return true;
        Stack<Object[]> stk = new Stack<>();
        stk.push(new Object[]{root, Integer.MIN_VALUE, Integer.MAX_VALUE});
        while(!stk.isEmpty()){
            Object[] obj = stk.pop();
            TreeNode curr= (TreeNode) obj[0];
            int left = (int) obj[1];
            int right = (int) obj[2]; 
            if(!(left < curr.val && curr.val < right))return false;
            if(curr.left!=null)stk.push(new Object[]{curr.left,left, curr.val});
            if(curr.right!=null)stk.push(new Object[]{curr.right,curr.val, right});
        }
        return true;
    }
}
