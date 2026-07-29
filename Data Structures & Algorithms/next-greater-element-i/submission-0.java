class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk = new Stack<>();
        int[] ng = new int[nums2.length];
        for(int i = nums2.length-1;i>=0;i--){
            // stk.push(nums2[i]);
            while(!stk.isEmpty() && nums2[stk.peek()]<=nums2[i]){
                stk.pop();
            }
            for(int j = 0; j < nums1.length; j++){
                if(nums2[i]==nums1[j]){
                    nums1[j] = stk.isEmpty() ? -1:nums2[stk.peek()];
                }
            }
            stk.push(i);
        }
        // for(int i = 0;i<)
        return nums1;
    }
}