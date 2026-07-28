class Twitter {
    private Map<Integer, Set<Integer>> users;
    private Map<Integer, Map<Integer,Integer>> tweets;
    private Integer count;
    public Twitter() {
        this.users = new HashMap<>();
        this.tweets = new HashMap<>();
        this.count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new HashMap<>());
        tweets.get(userId).put(tweetId, count);
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        
        if(tweets.containsKey(userId)){
            pq.addAll(tweets.get(userId).entrySet());
        }
        if(users.containsKey(userId) && !users.get(userId).isEmpty()){
            for(Integer followee: users.get(userId)){
                if(users.containsKey(followee)){
                    pq.addAll(tweets.get(followee).entrySet());
                }
            }
        }
        List<Integer> result = new LinkedList<>();
        while(!pq.isEmpty() && result.size()<10){
            result.add(pq.poll().getKey());
        }
        return result;

    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId ==followeeId) return;
        users.putIfAbsent(followerId, new HashSet<>());
        users.putIfAbsent(followeeId, new HashSet<>());
        users.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(users.containsKey(followerId)){
            users.get(followerId).remove(followeeId);
        }
    }
}
