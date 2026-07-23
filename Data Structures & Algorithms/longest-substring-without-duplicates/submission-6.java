class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0,left=0;
        
        Map<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(hm.containsKey(s.charAt(i))){
                left = Math.max(hm.get(s.charAt(i))+1,left); 
                // hm.put(s.charAt(i),i);
            }
            hm.put(s.charAt(i),i);
            max = Math.max(i-left+1,max);
        }
        return max;
    }
}
