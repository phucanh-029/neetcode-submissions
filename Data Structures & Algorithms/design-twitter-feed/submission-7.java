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
        if(!users.containsKey(userId)){
            Set<Integer> lst = new HashSet<>();
            users.put(userId, lst);
        }
        if(!tweets.containsKey(userId)){
            Map<Integer,Integer> mp = new HashMap<>();
            mp.put(tweetId, count);
            tweets.put(userId,mp);
        }
        else{
            Map<Integer,Integer> mp = tweets.get(userId);
            mp.put(tweetId, count);
            tweets.put(userId,mp);
        }
        
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        
        if(tweets.containsKey(userId)){
            for(Map.Entry<Integer, Integer> entry : tweets.get(userId).entrySet()){
                pq.add(entry);
            }
        }
        if(users.containsKey(userId) && !users.get(userId).isEmpty()){
            for(Integer followee: users.get(userId)){
                for(Map.Entry<Integer, Integer> entry : tweets.get(followee).entrySet()){

                    pq.add(entry);
               
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
        if(!users.containsKey(followerId)){
            Set<Integer> lst = new HashSet<>();
            users.put(followerId, lst);
        }
        if(!users.containsKey(followeeId)){
            Set<Integer> lst = new HashSet<>();
            users.put(followeeId, lst);
        }
        if(!users.get(followerId).contains(followeeId) && followeeId != followerId){
            users.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(users.containsKey(followerId)){
            users.get(followerId).remove(followeeId);
        }
    }
}
