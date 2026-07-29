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
        TreeNode beginNode = root;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i<len; i++){
                TreeNode curr = q.poll();
                beginNode = curr;
                if(isIdentical(beginNode,subRoot))return true;
            }
            if(beginNode.left!=null)q.add(beginNode.left);
            if(beginNode.right!=null)q.add(beginNode.right);
        }
        return false;
    }
    public boolean isIdentical(TreeNode subTree, TreeNode subRoot){
        if(subTree == null && subRoot==null) return true;
        if(subTree !=null && subRoot !=null && subTree.val == subRoot.val){
            return isIdentical(subTree.left,subRoot.left) && isIdentical(subTree.right,subRoot.right);
        }
        return false;
        
    }
    
}
