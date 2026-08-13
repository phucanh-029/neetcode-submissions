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
        int cnt = 0;
        if(root == null) return cnt;
        Stack<Pair<TreeNode, Integer>> stk = new Stack<>();
        stk.push(new Pair<>(root,root.val));
        while(!stk.isEmpty()){
            Pair<TreeNode, Integer> pair = stk.pop();
            TreeNode curr = pair.getKey();
            if(curr.val>=pair.getValue())cnt++;
            if(curr.left!=null){
                stk.push(new Pair<>(curr.left, Math.max(curr.left.val,pair.getValue())));
            }
            if(curr.right!=null){
                 stk.push(new Pair<>(curr.right,Math.max(curr.right.val, pair.getValue())));
            }
        }
        return cnt;
    }
}
