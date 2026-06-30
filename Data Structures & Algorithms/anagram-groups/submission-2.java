class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<List<List<Integer>>, List<String>> hm = new HashMap<>();
        for(int i = 0 ; i < strs.length; i++){
            List<List<Integer>> idx = new ArrayList<List<Integer>>();
            for(int j = 0; j < 27; j++){
                List<Integer> a = new ArrayList<>();
                a.add(j+96);
                a.add(0);
                idx.add(a);
            }
            for(int j = 0; j < strs[i].length(); j++){
                Integer cur = idx.get(strs[i].charAt(j)-96).get(1);
                idx.get(strs[i].charAt(j)-96).set(1, cur + 1);
            }
            if(!hm.containsKey(idx)){
                List<String> val = new ArrayList<>();
                val.add(strs[i]);
                hm.put(idx, val);
            }
            else{
                List<String> val = hm.get(idx);
                val.add(strs[i]);
                hm.put(idx,val);
            }
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for(List<String> it : hm.values()){
            result.add(it);
        }
        return result;
    }
}
