class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            freq.putIfAbsent(nums[i],0);
            freq.put(nums[i],freq.get(nums[i])+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a , b) ->  b.getValue() - a.getValue()
        );
        pq.addAll(freq.entrySet());
        int[] res = new int[k];
        while(!pq.isEmpty() && k > 0){
            var top = pq.poll();
            res[--k]=top.getKey();
        }
      
        return res;
    }
}
