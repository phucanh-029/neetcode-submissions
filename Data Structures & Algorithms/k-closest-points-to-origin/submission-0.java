class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<int[], Double>> pq = 
        new PriorityQueue<>((a,b) -> Double.compare(a.getValue(), b.getValue()));
        for(int i = 0; i< points.length;i++){
            pq.offer(new Pair<>(points[i], (double)(Math.pow(points[i][0],2)+Math.pow(points[i][1],2))));
        }
        int[][] res = new int[k][2];
        int t = 0;
        while(t<k){
            res[t++]=pq.poll().getKey();
        }
        return res;
    }
}
