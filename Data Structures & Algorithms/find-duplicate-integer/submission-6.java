class Solution {
    public int findDuplicate(int[] nums) {
        int slow =0,fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]]; 
            if(slow == fast) break;               
        }

        int slow2 = 0;
        while(true){
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow == slow2)return slow;
        }
    }
}
// nums[0]1 nums[1]3 nums[3]2 nums[2] 4
// nums[nums[0]1]3 nums[nums[3]2]4  nums[nums[4]2] 4


// nums[4] 2 nums[2] 4 nums[4] 2
//nums[0]1 nums[1]3 nums[3] 2
