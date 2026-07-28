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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot==null)return false;
        if(root == null && subRoot==null) return true;
        if(isIdentical(root,subRoot)) return true;
        boolean isIdenticalLeft = isSubtree(root.left,subRoot);
        boolean isIdenticalRight = isSubtree(root.right,subRoot);
        return isIdenticalLeft || isIdenticalRight;
    }
    public boolean isIdentical(TreeNode subTree, TreeNode subRoot){
        if(subTree == null && subRoot==null) return true;
        if(subTree !=null && subRoot !=null && subTree.val == subRoot.val){
            return isIdentical(subTree.left,subRoot.left) && isIdentical(subTree.right,subRoot.right);
        }
        return false;
        
    }
}
