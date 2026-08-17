class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int i = 0;i<nums.length;i++){
            pq.offer(nums[i]);
        }
        while(k>1){
            pq.poll();
            k--;
            // if( k==0) return pq.poll();
        }
        return pq.poll();
    }
}
