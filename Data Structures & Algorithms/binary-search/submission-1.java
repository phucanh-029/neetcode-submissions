class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r =nums.length;
        while(l<r){
            System.out.println(l+" "+r);
            int mid = l+(r-l)/2;
            System.out.println(mid+" "+nums[mid]);
            if(nums[mid]<target){
                l = mid+1;
            }
            else if(nums[mid]>target){
                r = mid;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
