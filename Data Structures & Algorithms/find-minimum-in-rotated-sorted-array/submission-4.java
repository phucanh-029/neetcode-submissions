class Solution {
    public int findMin(int[] nums) {
        int l = 0,r =nums.length;
        int res =nums[0];
        while(l<r){
            if(nums[l]<nums[r-1]){
                res = Math.min(res,nums[l]);
                break;
            }
            
            int mid = l+(r-l)/2;
            res = Math.min(res,nums[mid]);
            if(nums[l]<nums[mid]){
                l=mid+1;
            }
            else{
                r =mid;
            }
        }
        return res;
    }
}
