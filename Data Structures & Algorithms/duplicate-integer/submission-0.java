class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i],0);
            }
            else{
                return true;
            }
        }
        return false;
    }
}