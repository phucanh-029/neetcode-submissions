class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        dfs(nums,new ArrayList<>(), target,0,0);
        return res;
    }
    private void dfs(int[] nums, List<Integer> cur,int target, int i, int total){
        if(total == target){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int j = i;j< nums.length;j++){
            
            if(total+nums[j]>target){
                return;
            }
            cur.add(nums[j]);
            dfs(nums, cur, target, j, total+nums[j]);
            cur.remove(cur.size()-1);
        }
    }
}
