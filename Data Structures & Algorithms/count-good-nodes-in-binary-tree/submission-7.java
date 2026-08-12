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
    public int goodNodes(TreeNode root) {
        return cnt(root,root.val);
    }
    public int cnt(TreeNode root, int max){
        if(root == null) return 0;
        int res = (root.val >= max) ? 1 : 0;
        if(max<=root.val) max = root.val;
        res += cnt(root.left,max);
        res += cnt(root.right,max);
        return res;
    }
}
