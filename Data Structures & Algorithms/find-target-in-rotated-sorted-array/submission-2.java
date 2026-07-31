class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        int min = nums[0];
        while(l<r){

            int mid = l+(r-l)/2;
            // if(nums[l] == target) return l;
            // if(nums[r-1] == target) return r-1;
            // System.out.println(l+" "+r+ " "+ mid);
            if(nums[mid] == target) return mid;
            if(nums[mid]>nums[l]){
                if(nums[mid] < target || nums[l] > target){
                    l = mid + 1;
                }
                else{
                    r = mid;
                }
            }
            else{
                if(nums[mid] > target || nums[r-1] < target){
                    r = mid;
                }
                else{
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
