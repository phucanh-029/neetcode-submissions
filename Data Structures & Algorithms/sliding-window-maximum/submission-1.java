class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] res = new int[n-k+1];
        for(int i = 0;i<n-k+1;i++){
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
            for(int j = i;j<i+k;j++){
                pq.offer(nums[j]);
            }
            res[i] = pq.poll();
        }
        return res;
    }
}
