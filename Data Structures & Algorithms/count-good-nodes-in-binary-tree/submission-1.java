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
        if(root == null)return 0;
        HashMap<TreeNode, Integer> hm = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 1;
        hm.put(root, root.val);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null){
                    if(curr.left.val>=hm.get(curr)){
                        res++;
                        hm.put(curr.left, curr.left.val);
                    }
                    else{
                        hm.put(curr.left,hm.get(curr));
                    }
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    if(curr.right.val>=hm.get(curr)){
                        res++;
                        hm.put(curr.right, curr.right.val);
                    }
                    else{
                        hm.put(curr.right,hm.get(curr));
                    }
                    q.add(curr.right);
                }
            }
        }
        return res;
    }
}
