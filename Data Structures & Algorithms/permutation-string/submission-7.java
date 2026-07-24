class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c: s1.toCharArray()){
            hm.put(c, hm.getOrDefault(c,0)+1);
        }
        for(int i = 0;i<s2.length()-s1.length()+1;i++){
            HashMap<Character, Integer> cnt = new HashMap<>();
            if(!hm.containsKey(s2.charAt(i))){
                continue;
            }
            int l = 0;
            for(int j = i;j< i+s1.length();j++){
                char c = s2.charAt(j);
                if(!hm.containsKey(c)){
                    break;
                }
                cnt.put(c, cnt.getOrDefault(c,0)+1);
                if(cnt.get(c)> hm.get(c)){
                    break;
                }
                else{
                    l++;
                }
            }
            if(l == s1.length())return true;
        }
        // System.out.println(hm);
        return false;
    }
}
