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
        cnt++;
        while(!stk.isEmpty()){
            Pair<TreeNode, Integer> pair = stk.pop();
            TreeNode curr = pair.getKey();
            if(curr.left!=null){
                if(curr.left.val>=pair.getValue()){
                    stk.push(new Pair<>(curr.left, curr.left.val));
                    cnt++;
                }
                else stk.push(new Pair<>(curr.left, pair.getValue()));
            }
            if(curr.right!=null){
                if(curr.right.val>=pair.getValue()){
                    stk.push(new Pair<>(curr.right, curr.right.val));
                    cnt++;
                }
                else stk.push(new Pair<>(curr.right, pair.getValue()));
            }
        }
        return cnt;
    }
}
