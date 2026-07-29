class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int[] res = new int[nums1.length];
        for(int i = 0;i<nums1.length;i++){
            hm.put(nums1[i],i);
            res[i]=-1;
        }
        // System.out.println(re·);

        Stack<Integer> stk = new Stack<>();

        for(int i = nums2.length-1;i>=0;i--){
            // stk.push(nums2[i]);
            while(!stk.isEmpty() && nums2[stk.peek()]<=nums2[i]){
                stk.pop();
            }

            if(!stk.isEmpty() && hm.containsKey(nums2[i])){
                res[hm.get(nums2[i])]=nums2[stk.peek()];
            }
            
            stk.push(i);
        }
        // for(int i = 0;i<)
        return res;
    }
}