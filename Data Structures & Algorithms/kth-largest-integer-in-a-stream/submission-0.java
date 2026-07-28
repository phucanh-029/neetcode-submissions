class KthLargest {
    private List<Integer> list;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.list = Arrays.stream(nums).boxed().collect(Collectors.toCollection(LinkedList::new));
        this.k = k;
        // for(int nums: )
    }
    
    public int add(int val) {
        list.add(val);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(Integer i: list)pq.add(i);
        int tmp = k;
        // System.out.println("tmp "+tmp);
        while(!pq.isEmpty() && tmp>1){
            pq.poll();
            tmp--;
        }
        return pq.peek();
    }
}
