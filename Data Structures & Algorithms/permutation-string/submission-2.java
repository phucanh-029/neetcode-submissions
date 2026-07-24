class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        // System.out.println("S1 length: " + s1.length());
        for(int i = 0;i<s2.length()-s1.length()+1;i++){
            HashMap<Character, Integer> hm = new HashMap<>();
            for(char c: s1.toCharArray()){
                if(!hm.containsKey(c)){
                    hm.put(c,0);
                }
                hm.put(c, hm.get(c)+1);
            }

            int l = 0;
            if(!hm.containsKey(s2.charAt(i))){
                continue;
            }
            // System.out.println("index: "+ i);
            // System.out.println("substring: "+ s2.substring(i,i+ s1.length()));
            System.out.println(hm);
            for(int j = i; j < i + s1.length();j++){
                
                if(!hm.containsKey(s2.charAt(j))){
                    break;
                }
                else{
                    hm.put(s2.charAt(j), hm.get(s2.charAt(j))-1);
                    // System.out.println(s2.charAt(j) + " " + hm.get(s2.charAt(j)));
                    l++;
                    if(hm.get(s2.charAt(j))<0){
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
