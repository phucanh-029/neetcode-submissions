class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hm = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!hm.contains(nums[i])){
                hm.add(nums[i]);
            }
            else{
                return true;
            }
        }
        return false;
    }
}