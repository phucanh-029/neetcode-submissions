class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        
        int check = 0;
        for(int i = 0; i < s.length(); i++){
            Map<Character,Integer> hm = new HashMap<>();
            // hm.put(s.charAt(i),i);
            int left = check;
            while(left<i){
                hm.put(s.charAt(left),left);
                left++;
                if(hm.containsKey(s.charAt(left))){
                    check = hm.get(s.charAt(left))+1;
                }

            }
            max = Math.max(i-check+1,max);
        }
        return max;
    }
}
