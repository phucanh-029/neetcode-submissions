class Solution {
    public String minWindow(String s, String t) {
        if(s.length()< t.length())return "";
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c: t.toCharArray()) freq.put(c, freq.getOrDefault(c,0)+1);

        HashMap<Character, Integer> window = new HashMap<>();
        int[] res = {-1, -1};
        int min = 1000;
        int l = 0;
        int have = 0,need = freq.size();
        for(int r = 0;r<s.length();r++){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c,0)+1);
            if(freq.containsKey(c) && window.get(c).equals(freq.get(c))){
                have++;
            }
            while(have == need){//valid right
                if((r-l+1)<min){
                    min = r-l+1;
                    res[0]=l;
                    res[1]=r;
                }
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar)-1);
                if(freq.containsKey(leftChar) && window.get(leftChar)<freq.get(leftChar)) have--;//invalid left
                l++;
            }
        }
        return min == 1000 ? "": s.substring(res[0],res[1]+1);
    }
}
