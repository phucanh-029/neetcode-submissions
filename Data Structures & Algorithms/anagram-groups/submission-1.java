class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // 
        Map<String, List<String>> hm = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            int[] idx = new int[26];
            for(char c : strs[i].toCharArray()){
                idx[c-'a']++;
            }
            String key = Arrays.toString(idx);
            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(strs[i]);
        }
        return new ArrayList<>(hm.values());
    }
}
