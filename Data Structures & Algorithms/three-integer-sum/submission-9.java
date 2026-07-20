class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int l = 0, r = nums.length-1;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<r-1;i++){
            int target = -nums[i];
            if( i>0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = r;
            while(j<k){                
                if(nums[j]+nums[k]>target){
                    k--;
                }
                else if(nums[j]+nums[k]<target){
                    j++;
                }
                else{
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    k--;
                    j++;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
                
            }       
        }
        return res;
    }
}
