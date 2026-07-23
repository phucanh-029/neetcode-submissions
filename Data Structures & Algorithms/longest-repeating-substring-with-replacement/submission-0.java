class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0, l = 0;
        int maxf = 0;
        Map<Character,Integer> hm = new HashMap<>();
        for(int r = 0; r < s.length(); r++){
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r),0)+1);
            maxf = Math.max(hm.get(s.charAt(r)),maxf);
            while(( r - l + 1) - maxf > k){
                hm.put(s.charAt(l), hm.get(s.charAt(l))-1);
                l++;
            } 
            max = Math.max(r-l+1,max);
        }
        // for(int freq : freqs){
        //     System.out.println(freq);
        // }
        
        return max;
    }
}
