class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Map<Integer,Integer> res = new HashMap<>();
        int i = 0;
        for(int q : Arrays.stream(queries).sorted().toArray()){
            while(i<intervals.length && intervals[i][0] <= q){
                int l = intervals[i][0];
                int r = intervals[i][1];
                pq.offer(new int[]{r-l+1,r});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[1] < q){
                pq.poll();
            }
            res.put(q, pq.isEmpty() ? -1 : pq.peek()[0]);
        }
        int[] result = new int[queries.length];
        for(int j = 0; j < queries.length; j++){
            result[j] = res.get(queries[j]);
        } 
        return result;
    }
}
