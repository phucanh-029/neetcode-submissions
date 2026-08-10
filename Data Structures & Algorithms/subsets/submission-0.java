class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(0 ,curr ,nums, res);
        return res;
    }
    public void backtrack(int index, List<Integer> curr, int[] nums, List<List<Integer>> res){
        if(index == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        backtrack(index+1,curr,nums,res);
        curr.remove(curr.size()-1);
        backtrack(index+1,curr,nums,res);
    }
}
