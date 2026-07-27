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
    public int diameterOfBinaryTree(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        Map<TreeNode, int[]> mp = new HashMap<>();
        mp.put(null, new int[2]);
        while(!stk.isEmpty()){
            TreeNode node = stk.peek();
            if(node.left!=null && !mp.containsKey(node.left)){
                stk.push(node.left);
            }
            else if(node.right!=null && !mp.containsKey(node.right)){
                stk.push(node.right);
            }else{
                node = stk.pop();
                int[] leftData = mp.get(node.left);
                int[] rightData = mp.get(node.right);
                int height = 1 + Math.max(leftData[0],rightData[0]);
                int diameter = Math.max(leftData[0]+rightData[0], Math.max(leftData[1],rightData[1]));
                mp.put(node, new int[]{height, diameter});
            
            }
            
        }
        return mp.get(root)[1];
    }
}
