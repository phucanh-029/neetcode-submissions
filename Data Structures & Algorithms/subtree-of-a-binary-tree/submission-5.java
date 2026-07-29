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
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
    
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(isIdentical(curr,subRoot))return true;
            if(curr.left!=null)q.add(curr.left);
            if(curr.right!=null)q.add(curr.right);
        }
        return false;
    }
    public boolean isIdentical(TreeNode p, TreeNode q){
        if(p == null && q==null) return true;
        if(p == null || q==null) return false;
        Stack<TreeNode[]> stk = new Stack<>();
        stk.push(new TreeNode[]{p,q});
        while(!stk.isEmpty()){
            TreeNode[] curr = stk.pop();
            TreeNode currP = curr[0];
            TreeNode currQ = curr[1];
            if(currP == null && currQ == null) continue;
            if(currP == null || currQ == null || currP.val != currQ.val) return false;
            stk.push(new TreeNode[]{currP.left, currQ.left});
            stk.push(new TreeNode[]{currP.right, currQ.right});
            
        }
        return true;
    }
    
}
