class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        
        while(true){
            slow = nums[slow];
            fast= nums[nums[fast]];
            // slow--;
            // fast--;
            if(slow == fast)break;
        }
        // return slow;
        //slow = 3
        int slow2 = 0;
        while(true){
            slow = nums[slow];// 2
            slow2 = nums[slow2];
            if(slow == slow2)return slow;
        }

    }
}

// slow 0-11 1->2   2->3  3 ->
// fast 0- 1->2 1-2->3  3 -> 2 ->2

// slow nums[0] 1 nums[1] 3 nums[2] = 4 nums[4] = 2 nums[2] = 4
// slow2 nums[nums[0]] 3 nums[nums[3]] 4 nums[nums[4]] = 4 nums[nums[4]]=4 nums[nums[4]]=4

// iterate till we got slow = slow2, this could be o(2n) ->0(n)
