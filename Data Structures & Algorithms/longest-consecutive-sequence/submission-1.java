class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> hm = new HashMap<>();
        int res=0;
        for(int i = 0; i < nums.length; i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i], hm.getOrDefault(nums[i]-1,0) + hm.getOrDefault(nums[i]+1,0) + 1);
                hm.put(nums[i] - hm.getOrDefault(nums[i]-1,0),hm.get(nums[i]));
                hm.put(nums[i] + hm.getOrDefault(nums[i]+1,0),hm.get(nums[i]));
                res = Math.max(hm.get(nums[i]), res);
            }
        }
        return res;
    }
}
