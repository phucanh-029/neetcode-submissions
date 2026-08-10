// public Node{
//     int val;
//     Node prev;
//     Node next;
//     public Node(int val){
//         this.val = val;
//         this.prev = null;
//         this.next = null;
//     }
// }

class LRUCache {
    private HashMap<Integer, Integer> cache;
    private int capacity;
    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                return size() > capacity;
            }
        };
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return cache.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
    }
}
