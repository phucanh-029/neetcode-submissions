class TimeMap {
    Map<String, TreeMap<Integer, String>> timeMap;
    public TimeMap() {
        this.timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // timeMap.computeIfAbsent(key, k ->  new TreeMap<>()).put(timestamp, value);
        timeMap.put(key, timeMap.getOrDefault(key, new TreeMap<>()));
        timeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer,String> time = timeMap.get(key);
        if(time == null) return "";
        return time.floorEntry(timestamp)== null ? "" : time.floorEntry(timestamp).getValue();
    }
}
