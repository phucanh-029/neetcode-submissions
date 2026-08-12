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
        // HashMap<TreeNode, Integer> hm = new HashMap<>();
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, root.val));
        int res = 1;
        while(!q.isEmpty()){
            
                Pair<TreeNode,Integer> pair = q.poll();
                TreeNode curr = pair.getKey();
                if(curr.left!=null){
                    if(curr.left.val>=pair.getValue()){
                        res++;
                        q.add(new Pair<>(curr.left, curr.left.val));
                    }
                    else{
                        q.add(new Pair<>(curr.left,pair.getValue()));
                    }
                }
                if(curr.right!=null){
                    if(curr.right.val>=pair.getValue()){
                        res++;
                        q.add(new Pair<>(curr.right, curr.right.val));
                    }
                    else{
                        q.add(new Pair<>(curr.right,pair.getValue()));
                    }
                }
            
        }
        return res;
    }
}
