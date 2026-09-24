class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,new ArrayList<>(), 0, 0, target);
        return res;
    }
    private void backtrack(int[] candidates,List<Integer> cur, int i, int total, int target){
        if(total == target){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(total > target || i == candidates.length) return;
        cur.add(candidates[i]);
        backtrack(candidates, cur, i+1, total+ candidates[i], target);
        cur.remove(cur.size()-1);
        while(i+1 < candidates.length && candidates[i] == candidates[i+1])i++;
        backtrack(candidates, cur, i+1, total, target);
    }
    
}
