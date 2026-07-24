class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        for(int i = 0;i<s2.length()-s1.length()+1;i++){
            int[] freq = new int[26];
            for(char c : s1.toCharArray()){
                freq[c-'a']++;
            }
            int l = 0;
            if(freq[s2.charAt(i)-'a']==0){
                continue;
            }
            // System.out.println("index: "+ i);
            // System.out.println("substring: "+ s2.substring(i,i+ s1.length()));
            // System.out.println(hm);
            for(int j = i; j < i + s1.length();j++){
                
                if(freq[s2.charAt(j)-'a']==0){
                    break;
                }
                else{
                    freq[s2.charAt(j)-'a']--;
                    // System.out.println(s2.charAt(j) + " " + hm.get(s2.charAt(j)));
                    l++;
                    if(freq[s2.charAt(j)-'a']<0){
                        l--;
                        break;
                    }
                }
                
            }
            // System.out.println(hm);
            // System.out.println(l);
            if(l==s1.length())return true;
        }
        // System.out.println(hm);
        return false;
    }
}
