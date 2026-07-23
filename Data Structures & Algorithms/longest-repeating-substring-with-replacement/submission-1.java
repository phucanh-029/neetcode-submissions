class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        HashSet<Character> charSet = new HashSet<>();
        for(char c : s.toCharArray()){
            charSet.add(c);
        }
        for(char c : charSet){
            int cnt = 0, l = 0;
            for(int r = 0; r < s.length(); r++){
                if(s.charAt(r) == c){
                    cnt++;
                }
                while((r-l+1) - cnt>k){
                    if(s.charAt(l)==c){
                        cnt--;
                    }
                    l++;
                }
                res = Math.max(r-l+1,res);
            }
        }
        return res;
    }
}
