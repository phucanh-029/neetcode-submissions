class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int l = 0, r = nums.length-1;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Set<Integer> entries = new HashSet<>();
        Set<String> pair = new HashSet<>();
        for(int i = 0;i<r-1;i++){
            int target = -nums[i];
            if(!entries.contains(target)){
                entries.add(target);
                int j = i+1, k = r;
                while(j<k){
                    if(nums[j]+nums[k]>target){
                        k--;
                    }
                    else if(nums[j]+nums[k]<target){
                        j++;
                    }
                    else{
                        if(!pair.contains(nums[j]+""+nums[k])){
                            res.add(List.of(nums[i], nums[j], nums[k]));
                            pair.add(nums[j]+""+nums[k]);
                        }
                        k--;
                        j++;
                    }
                }
            }
            
        }
        return res;
    }
}
