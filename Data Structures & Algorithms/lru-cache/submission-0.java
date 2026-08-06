class LRUCache {
    private Map<Integer, Integer> cache;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f,true){
            protected  boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                return size()>capacity;
            }
        };
    }
    
    public int get(int key) {
        return cache.get(key) == null? -1: cache.get(key);
    }
    
    public void put(int key, int value) {
        cache.put(key,value);
    }
}
