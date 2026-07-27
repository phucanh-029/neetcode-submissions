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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode node = root, last=null;
        HashMap<TreeNode, Integer> hm = new HashMap<>();
        while(!stk.isEmpty() || node!=null){
            if(node!=null){
                stk.push(node);
                node = node.left;
            }
            else{
                node = stk.peek();
                if(node.right==null || last == node.right){
                    stk.pop();
                    int leftHeight = hm.getOrDefault(node.left,0);
                    int rightHeight = hm.getOrDefault(node.right,0);
                    if(Math.abs(leftHeight - rightHeight) > 1 ){
                        return false;
                    }
                    hm.put(node, 1+ Math.max(leftHeight,rightHeight));
                    last = node;
                    node = null;
                }else{
                    node = node.right;
                }
            }

        }
        System.out.println(hm);
        return true;
    }
}
